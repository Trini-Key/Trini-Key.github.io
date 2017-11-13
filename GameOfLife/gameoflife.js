$(document).ready(function(){

    control();

    function control() {
        var rows = 25;
        var columns = 25;
        grid = createArray(rows, columns);
        nextGrid = createArray(rows, columns);
        var s;
        var is;
        var count = 1;
        var icount = 1;
        var tb = "<table>";

        main();

        function main() {
            createGrid();

            $("#Submit").click(function () {
                changeSize();
            });

            $("#step").click(function () {
                logic();
            });

            $("#23_steps").click(function () {
                s = setInterval(step, 150);
            });

            $("#start").click(function () {
                is = setInterval(infinite, 150);
            });

            $("#stop").click(function () {
               stop();
            });

            $("#reset").click(function () {
                reset();
            });

            $("#choice").click(function(){
                choice();
            });
        }// end main function

        function createGrid() {
            for (var i = 0; i < rows; i++) {
                tb += "<tr>";
                for (var j = 0; j < columns; j++) {
                    tb += "<td data-row=\"" + i + "\"" + " data-col=\"" + j + "\"" + " id=" + "\"" + i + "d" + j + "\"" + ">" + "</td>";
                }
                tb += "</td>";
            }
            tb += "</table>";
            document.getElementById("canvas").innerHTML = tb;
        }// end createGrid function

        function step() {
            logic();
            console.log("the count is: " + count);
            count++;
            if (count >= 24 || icount == 0) {
                count = 1;
                clearInterval(s);
            }
        }// end step function

        function infinite() {
            logic();
            if(icount == 0){
                icount = 1;
                clearInterval(is);
            }

        }// end infinite function

        function stop(){
            clearInterval(s);
            icount--;
            clearInterval(is);
        }

        function reset(){
            stop();
            tb = "<table>";
            grid = "";
            nextGrid = "";
            grid = createArray(rows, columns);
            nextGrid = createArray(rows, columns);
            control();
            changeSize();
        }// end reset function

        function changeSize() {
            tb = "<table>";
            rows = document.getElementById("rows").value;// the values that go in the html always does rows first and so its always flipped
            columns = document.getElementById("columns").value;// if you try to use the first input for columns it still manages to make it rows.
            grid = "";
            nextGrid = "";
            grid = createArray(rows, columns);
            nextGrid = createArray(rows,columns);
            createGrid();

            $('table tr td').click(function () {
                var d_row = $(this).attr('data-row');
                var d_col = $(this).attr('data-col');
                var col_row = d_row + "d" + d_col;
                if (grid[d_row][d_col] == 0 || grid[d_row][d_col] == null) {
                    $("#" + d_row + "d" + d_col).css("background", "black");
                    grid[d_row][d_col] = 1;
                } else {
                    $("#" + d_row + "d" + d_col).css("background", $("table tr td").css("background"));// does the same as body background because it inherited.
                    // $("#"+d_col+"d"+d_col).css("background", $("body").css("background")); // this sets the color back to the default color of the body.
                    grid[d_row ][d_col] = 0;
                }
            });// end click function
        }// end change size function

        function createArray(row, column ) { //creates a 2 dimensional array of required height
            var arr = [];
            for (var i = 0; i < row; i++) {
                arr[i] = new Array();
                for (var j = 0; j < column; j++) {
                    arr[i][j] = 0;
                }
            }
            return arr;
        }//end createArray

        function neighbors(curr_row, curr_col) {
            var neighbors = 0;
            for (var r = -1; r <= 1; r++) {
                for (var c = -1; c <= 1; c++) {
                    if (curr_row + r >= 0 && curr_col + c >= 0 && curr_row + r < rows && curr_col + c < columns) {
                        neighbors += grid[curr_row + r][curr_col + c];
                    }// end if
                }// end nest for
            }//end for
            neighbors -= grid[curr_row][curr_col];
            return neighbors; //return the number of neighbors a cell has
        }//end neighbors function

        function logic() {
            for (var i = 0; i < rows; i++) {
                for (var j = 0; j < columns; j++) {
                    var myNeighbors = neighbors(i, j);
                    // console.log("number of neighbors: " + myNeighbors); //used this to debug checking neighbors make sure array is correctly initialized as a 2d array.
                    if (grid[i][j] === 0) {
                        switch (myNeighbors) {
                            case 3:
                                $("#" + i + "d" + j).css("background", "black");
                                nextGrid[i][j] = 1;
                                break;
                            default:
                                nextGrid[i][j] = 0;
                        }//end switch statement
                    } else if (grid[i][j] === 1) {
                        switch (myNeighbors) {
                            case 2:
                                nextGrid[i][j] = 1;
                                break;
                            case 3:
                                nextGrid[i][j] = 1;
                                break;
                            default:
                                $("#" + i + "d" + j).css("background", "white");
                                nextGrid[i][j] = 0;
                                break;
                        }//end switch statement
                    }//end else if
                }//end nested for
            }//end for

            for (i = 0; i < rows; i++) {
                for (j = 0; j < columns; j++) {
                    grid[i][j] = nextGrid[i][j];
                    nextGrid[i][j] = 0;
                }//end nest for
            }//end for
        }//end logic function

        $('table tr td').click(function () {
            var d_row = $(this).attr('data-row');
            var d_col = $(this).attr('data-col');
            var col_row = d_row + "d" + d_col;
            if (grid[d_row][d_col] == 0 || grid[d_row][d_col] == null) {
                $("#" + d_row + "d" + d_col).css("background", "black");
                grid[d_row][d_col] = 1;
            } else {
                $("#" + d_row + "d" + d_col).css("background", $("table tr td").css("background"));// does the same as body background because it inherited.
                // $("#"+d_col+"d"+d_col).css("background", $("body").css("background")); // this sets the color back to the default color of the body.
                grid[d_row ][d_col] = 0;
            }
        });// end click function

        function choice() {
            var choose = $("#life_style option:checked").val();

            switch (choose) {
                case "block":
                    grid[1][1] = 1;
                    grid[1][2] = 1;
                    grid[2][1] = 1;
                    grid[2][2] = 1;
                    for(var b = 0; b <= rows; b++){
                        for(var d = 0; d <= columns; d++){
                            console.log(grid[b][d]);
                            if(grid[b][d] === 1){
                                $("#" + b + "d" + d).css("background", "black");
                            }
                        }
                    }
                    break;
                case "blinker":
                    grid[2][1] = 1;
                    grid[2][2] = 1;
                    grid[2][3] = 1;
                    for(b = 0; b <= rows; b++){
                        for(d = 0; d <= columns; d++){
                            if(grid[b][d] === 1){
                                $("#" + b + "d" + d).css("background", "black");
                            }
                        }
                    }
                    break;
                case "toad":
                    grid[1][2] = 1;
                    grid[1][3] = 1;
                    grid[1][4] = 1;
                    grid[2][1] = 1;
                    grid[2][2] = 1;
                    grid[2][3] = 1;
                    for(b = 0; b <= rows; b++){
                        for(d = 0; d <= columns; d++){
                            if(grid[b][d] === 1){
                                $("#" + b + "d" + d).css("background", "black");
                            }
                        }
                    }
                    break;
                case "glider":
                    grid[0][1] = 1;
                    grid[1][2] = 1;
                    grid[2][0] = 1;
                    grid[2][1] = 1;
                    grid[2][2] = 1;
                    for(b = 0; b <= rows; b++){
                        for(d = 0; d <= columns; d++){
                            if(grid[b][d] === 1){
                                $("#" + b + "d" + d).css("background", "black");
                            }
                        }
                    }
                    break;
                case "glider_gun":
                    if(rows >= 11 && columns >= 38){
                        console.log("i am in case glider gun")
                        grid[1][25] = 1;
                        grid[2][25] = 1;
                        grid[2][23] = 1;
                        grid[3][13] = 1;
                        grid[3][14] = 1;
                        grid[3][21] = 1;
                        grid[3][22] = 1;
                        grid[3][35] = 1;
                        grid[3][36] = 1;
                        grid[4][12] = 1;
                        grid[4][16] = 1;
                        grid[4][21] = 1;
                        grid[4][22] = 1;
                        grid[4][35] = 1;
                        grid[4][36] = 1;
                        grid[5][1] = 1;
                        grid[5][2] = 1;
                        grid[5][11] = 1;
                        grid[5][17] = 1;
                        grid[5][21] = 1;
                        grid[5][22] = 1;
                        grid[6][1] = 1;
                        grid[6][2] = 1;
                        grid[6][11] = 1;
                        grid[6][15] = 1;
                        grid[6][17] = 1;
                        grid[6][18] = 1;
                        grid[6][23] = 1;
                        grid[6][25] = 1;
                        grid[7][11] = 1;
                        grid[7][17] = 1;
                        grid[7][25] = 1;
                        grid[8][12] = 1;
                        grid[8][16] = 1;
                        grid[9][13] = 1;
                        grid[9][14] = 1;
                    }else{
                        alert("Must have a row size of at least 10 and column size of at least 37 to use glider gun preset!");
                    }//end if
                    for(b = 0; b <= rows; b++){
                        for(d = 0; d <= columns; d++){
                            if(grid[b][d] === 1){
                                $("#" + b + "d" + d).css("background", "black");
                            }
                        }
                    }
                    break;
                default:
                    break;
            }// end of switch
        }// end of choice function
    }// end control function
});//end ready function
