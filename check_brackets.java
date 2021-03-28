import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
	Bracket(char type, int position) {
		this.type = type;
		this.position = position;
	}

	boolean Match(char c) {
		if (this.type == '[' && c == ']')
			return true;
		if (this.type == '{' && c == '}')
			return true;
		if (this.type == '(' && c == ')')
			return true;
		return false;
	}

	char type;
	int position;
}

class check_brackets {

	public static void main(String[] args) throws IOException {

		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();

		Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
		int index = -1;
		for (int position = 0; position < text.length(); ++position) {
			char next = text.charAt(position);

			if (next == '(' || next == '[' || next == '{') {
				// Process opening bracket, write your code here+
				
				//pushes the new bracket to the stack to the location = position
				opening_brackets_stack.push(new Bracket(next,position));
				index=position+1;
			}

			if (next == ')' || next == ']' || next == '}') {
				// Process closing bracket, write your code here

				//if stack is empty OR if the closing bracket doesn't match
				if( ((opening_brackets_stack.isEmpty()) ||!opening_brackets_stack.peek().Match(next))) { 
					index = position+1;         //index=total number of brackets pushed which is the position of the last bracket plus 1 
					break;
				} else {
					opening_brackets_stack.pop(); //if it matches, then pop the last bracket out which will finally lead the stack to be empty if all brackets match
					
				}
			}
		}

		// Printing answer, write your code here

		// print "success" if the brackets are balanced or matching, if not, print the point at which the balance is broken
		if( opening_brackets_stack.isEmpty()) {
			System.out.println("Success");
		} else {
			System.out.println(index); 
		}
	}
}
