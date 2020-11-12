function validate(str)
{
	var stack = [];
	for(ch of str)
	{
		if(ch==='[' || ch === '{' || ch === '(') 
		{
			stack.push(ch);
		}
		else if(ch===']')
		{
			if(stack.length === 0)
			{
				console.log("Invalid braces");
				return false;
			}
			var top = stack.pop();
			if(top!= '[')
			{
				console.log("Invalid braces");
				return false;
			}
		}
		else if(ch === '}')
		{
			if(stack.length === 0)
			{
				console.log("Invalid braces");
				return false;
			}
			var top = stack.pop();
			if(top!= '{')
			{
				console.log("Invalid braces");
				return false;
			}
		}
		else if(ch === ')')
		{
			if(stack.length === 0)
			{
				console.log("Invalid braces");
				return false;
			}
			var top = stack.pop();
			if(top!= '(')
			{
				console.log("Invalid braces");
				return false;
			}
		}
		else
		{
			console.log.("Invalid Input");
			return false;
		}
	}
	if(stack.length != 0)
	{
		console.log("Invalid braces");
		return false;
	}
	else
	{
		console.log("Valid Brackets!");
		return true;
	}
}


			
