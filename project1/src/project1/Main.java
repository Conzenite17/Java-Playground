package project1;

import java.util.Arrays;

public class Main {
	public static double addition(double value1, double value2) {		
		return value1 + value2;
	}
	
	public static double subtraction(double value1, double value2) {		
		return value1 - value2;
	}
	
	public static double multiplication(double value1, double value2) {		
		return value1 * value2;
	}
	
	public static double division(double value1, double value2) {		
		return value1 / value2;
	}
	
	public static double myExponential(double value1, double value2) {
		double result = 0;
		for (int i = 0; i < value2; i++) {
			result +=value1 * value1;
		}
		return result;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is my first project, Hello world!");
		
		
		//In Java you can do math and it would be handy to use functions
		System.out.println("Some maths:");
		//pick some numbers:
		double num1 = 4;
		double num2 = 3;
		System.out.println("With numbers " + num1 + " and " + num2);
		System.out.println(num1 + " + " + num2 + " = " + addition(num1, num2));
		System.out.println(num1 + " - " + num2 + " = " + subtraction(num1, num2));
		System.out.println(num1 + " x " + num2 + " = " + multiplication(num1, num2));
		System.out.println(num1 + " / " + num2 + " = " + division(num1, num2));
		//We can try doing calculating them as exponents
		System.out.println(num1 + " ^ " + num2 + " = " + myExponential(num1, num2));
		
		
		System.out.println();
		//Functions are so easy to manage when used like this.
		//Lets just explore this idea a bit further,
		//We will use a more complex mathematical function
		//e.g. Calculations of a Regular 2D Shapes
		//2D
		//Print Shape
		Shape square = new Shape("Square", 4);
		System.out.println(square.shapeName + ":");
		System.out.println();
		int gridSize = 100; //Square size of grid
		int x = gridSize;
		int y = gridSize;
		int[][] graph = new int[y][x];
		for (int[] row: graph) {
			Arrays.fill(row, 0);
		}
		drawShapeOnGraph(square, graph, gridSize);
		printGraph(graph, gridSize);
	}
	
	public static void printGraph(int[][] graph, int gridSize){
		for (int y = gridSize - 1; y > -1; y -= 1) {
			for (int x = 0; x < gridSize; x += 1) {
				if (y == gridSize/2 && x == gridSize/2) {
					System.out.print("*");
				} else {
					if (graph[y][x] == 1) {
						System.out.print("0");
					} else {
						System.out.print("-");
					}			
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static double getGradient(int x1, int y1, int x2, int y2){
		return (y2 - y1)/ (x2 - x1);
	}
	
	private static double getYIntercept(double m, int x, int y){
		return y - (x*m);
	}

	private static void drawShapeOnGraph(Shape shape, int[][] graph, int gridSize) {		
		double angleFromCentreLine = 360 / shape.numberOfSides; //degrees
		double theta = angleFromCentreLine / 180; //...PI radians
		double pi = 3.14;
		for (int i = 0; i < shape.numberOfSides; i++) {
			//Set start and end of each line
			int x1 = (gridSize/2 + (int)Math.round(((gridSize/2)-1) * Math.cos(i * theta * pi)));
			int y1 = (gridSize/2 + (int)Math.round(((gridSize/2)-1) * Math.sin(i * theta * pi)));
			int x2 = (gridSize/2 + (int)Math.round(((gridSize/2)-1) * Math.cos((i+1) * theta * pi)));
			int y2 = (gridSize/2 + (int)Math.round(((gridSize/2)-1) * Math.sin((i+1) * theta * pi)));
			int x = x1;
			int y = y1;
			graph[y][x] = 1;
			//Fill in !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			double m = getGradient(x1, y1, x2, y2);
			if (x2 > x1){
				if (y2 > y1){
					//m = +
				} else if (y2 < y1){
					//m = -
				} else {
					//m = 0
				}
			} else {
				if (y2 > y1){
					//m = -
				} else if (y2 < y1){
					//m = +
				} else {
					//m = 0
				}
			}
			
		}
				
	}
}
