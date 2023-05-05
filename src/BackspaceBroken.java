/* ------------------------------------------------------------------------------------------------------------
 * May 5th, 2023
 * ------------------------------------------------------------------------------------------------------------
 */

import java.util.Scanner;
import java.util.Stack;

public class BackspaceBroken
{
	public static void main(String[] args)
	{
		try (Scanner sc = new Scanner(System.in))//Try w/Resources (for auto-closing Scanner)
		{
			Stack<Character> cStack = new Stack<Character>();

			System.out.print("Please enter your string here (include '#'s to erase previous characters;\nmultiple '#'s erase multiple characters): ");
			String tIn = sc.nextLine().toString().strip();

			for (char c : tIn.toCharArray())
			{
				cStack.push(c);

				if (!cStack.isEmpty() && cStack.peek() == '#')
				{
					if (cStack.size() > 1) {cStack.pop(); cStack.pop();}
					else cStack.pop();
				}
			}

			if (!cStack.isEmpty())
			{
				StringBuilder sb = new StringBuilder();
				for (char h : cStack) sb.append(h);
				System.out.print("\nOutput: \"" + sb.toString() + "\"");
			}
			else
				System.out.print("\nOutput: \" \"");
		}
	}
}
