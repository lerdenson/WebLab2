<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru-RU">
<head>
    <meta charset="utf-8" content="text/html"
          http-equiv="Content-Type">
    <title>First Lab Web</title>
    <link href="style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div id="container">
    <div id="header">
        <a href="https://github.com/lerdenson/WebLab2" style="text-decoration: none; color: white; font-size: 36px">
            <span>Morozov Maxim</span>
            <span>P3212</span>
            <span>Variant 41989</span>
        </a>
    </div>
    <div id="page">
        <div id="content">
            <div id="input-field">
                <h2></h2>
                <h3>Заполните форму ниже, пожалуйста:</h3>
                <section>
                    <form action="controller-servlet" id="toSend">
                        <div>
                            Координата Х:<br>
                            <label for="check1">-3:</label>
                            <input class="radio" id="check1" name="X" type="radio" value=-3>
                            <label for="check2">-2:</label>
                            <input class="radio" id="check2" name="X" type="radio" value=-2>
                            <label for="check3">-1:</label>
                            <input class="radio" id="check3" name="X" type="radio" value=-1>
                            <label for="check4">0:</label>
                            <input class="radio" id="check4" name="X" type="radio" value=0>
                            <label for="check5">1:</label>
                            <input class="radio" id="check5" name="X" type="radio" value=1>
                            <label for="check6">2:</label>
                            <input class="radio" id="check6" name="X" type="radio" value=2>
                            <label for="check7">3:</label>
                            <input class="radio" id="check7" name="X" type="radio" value=3>
                            <label for="check8">4:</label>
                            <input class="radio" id="check8" name="X" type="radio" value=4>
                            <label for="check9">5:</label>
                            <input class="radio" id="check9" name="X" type="radio" value=5>
                        </div>
                        <div>
                            <label for="Y">Координата Y:<br></label>

                            <input id="Y" name="Y" placeholder="Введите Y от -3 до 3" type="text" maxlength="6">
                        </div>
                        <div>
                            <label for="R_value">R value:</label>
                            <select id="R_value" size="1" name="R">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>
                        <div class="errorField"></div>
                        <div><input class="button" type="submit" value="Отправить"></div>
                    </form>
                </section>
            </div>
            <div id="content-separator"></div>
            <div id="ajax">
                <table id="the-only-table">
                    <tr>
                        <td>X</td>
                        <td>Y</td>
                        <td>R</td>
                        <td>Result</td>
                        <td>Date</td>
                    </tr>
                </table>
            </div>
        </div>

        <div id="sidebar">
            <img id="duck" src="blue_rotate.jpg">
            <div id="field">
                <img id="zone" src="field.png">
            </div>

        </div>
    </div>
    <div class="clear">
    </div>
</div>
<script src="script.js" type="text/javascript"></script>
</body>
</html>