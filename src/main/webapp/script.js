let input = document.querySelector("#Y")
let span = document.querySelector(".errorField")
let rSelect = document.querySelector("#R_value")
let radio = document.getElementsByClassName("radio")
let table = document.querySelector("#the-only-table")
let field = document.getElementById("field")
let form = document.getElementById("toSend")




window.onload = function (e) {
    let formData = new FormData(form)
    formData.set("ONLOAD", "true")
    sendRequest("POST", "controller-servlet", formData)
        .then(addRow)
        .catch(err => console.log(err))

}

document.querySelector("#field").onclick = function (e) {
    e.preventDefault()
    let values = {
        x: null,
        y: null,
        r: null
    };
    values.r = Number($('#R_value').val());
    if (values.r === null) {
        notValid(span, "Выберите R")
    } else {
        if (e.clientX < 293 && e.clientY < 590 && e.clientY > 303) {

            let xParent = 0;
            let yParent = 0;
            let parent = e.currentTarget
            while (parent) {
                xParent += (parent.offsetLeft - parent.scrollLeft + parent.clientLeft);
                yParent += (parent.offsetTop - parent.scrollTop + parent.clientTop);
                parent = parent.offsetParent;
            }

            values.x = Math.round((e.clientX - xParent - 138) * values.r) / 100
            values.y = Math.round(-(e.clientY - yParent - 138) * values.r) / 100

            let img = document.createElement("img")
            img.src = "circle.png"
            img.style.height = 10 + "px"
            img.style.width = 10 + "px"
            img.style.left = (e.clientX - 5) + "px"
            img.style.top = (e.clientY -64 - 5) + "px"
            img.style.position = "absolute"

            e.currentTarget.appendChild(img)

            let formData = new FormData(form)
            formData.set("X", values.x.toString())
            formData.set("Y", values.y.toString())
            formData.set("R", values.r.toString())
            formData.set("ONLOAD", "false")
            sendRequest("POST", "controller-servlet", formData)
                .then(addRow)
                .catch(err => console.log(err));
        }
    }
}


document.querySelector(".button").onclick = function (e) {
    e.preventDefault()
    if (!isChecked(radio)) {
        notValid(span, "Выберите хотя бы один X")
    } else if (!isNumber(input.value) || Math.abs(+input.value) > 3 || input.value === "") {
        notValid(span, "Введите число от -3 до 3")
    } else {
        valid(span, "")
        let formData = new FormData(form)
        formData.set("ONLOAD", "false")
        sendRequest("POST", "controller-servlet", formData)
            .then(addRow)
            .catch(err => console.log(err));
    }
}

function addRow(data) {
    if (data[0].result.toString() !== ("none") && data[0].state.toString() !== ("true")) {
        for (let i = 0; i < data.length; i++) {
            let row = table.insertRow();
            let cell = row.insertCell(0)
            let text = document.createTextNode(data[i].x)
            cell.appendChild(text);
            cell = row.insertCell(1)
            text = document.createTextNode(data[i].y)
            cell.appendChild(text);
            cell = row.insertCell(2)
            text = document.createTextNode(data[i].r)
            cell.appendChild(text);
            cell = row.insertCell(3)
            text = document.createTextNode(data[i].result)
            cell.appendChild(text);
            cell = row.insertCell(4)
            text = document.createTextNode(data[i].date)
            cell.appendChild(text);
            valid(span, "")
        }
    } else {
        notValid(span, data[0].message)
    }
}

function sendRequest(method, url, data = new FormData(form)) {
    return fetch(url, {
        method: method,
        body: data
    }).then(response => {
        return response.json()
    })
}


function isNumber(value) {
    return !isNaN(value) && isFinite(+value);
}

function notValid(element, message) {
    element.innerHTML = message
}

function valid(element, message) {
    element.innerHTML = message
}

function isChecked(massive) {
    for (let i = 0; i < massive.length; i++) {
        if (massive.item(i).checked) {
            return true
        }
    }
    return false
}