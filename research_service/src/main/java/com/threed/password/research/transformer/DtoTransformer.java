package com.threed.password.research.transformer;

import com.threed.password.research.*;
import com.threed.password.research.dto.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DtoTransformer {

	public static TextPasswordDto convertToTextPasswordDto(TextPassword textPassword) {

		TextPasswordDto textPasswordDto= null;
		if (textPassword != null) {

			textPasswordDto = new TextPasswordDto();
			textPasswordDto.setUserName(textPassword.getUserName());
			textPasswordDto.setPassword(textPassword.getPassword());
			textPasswordDto.setReEnteredPassword(textPassword.getPassword());

		}
		return textPasswordDto;
	}
	public static TextPassword convertToTextPassword(TextPasswordDto textPasswordDto) {

		TextPassword textPassword = null;
		if (textPasswordDto != null) {

			try {
				textPassword = new TextPassword();
				textPassword.setUserName(textPasswordDto.getUserName());
				textPassword.setPassword(textPasswordDto.getPassword());
				return textPassword;
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static GraphicalPassword convertToGraphicalPassword(GraphicalPasswordDto graphicalPasswordDto) {

		GraphicalPassword graphicalPassword = null;
		if (graphicalPasswordDto != null) {


				graphicalPassword = new GraphicalPassword();
				graphicalPassword.setUserName(graphicalPasswordDto.getUserName());

				graphicalPassword.setPassword(new JSONArray(graphicalPasswordDto.getPassword()).toString());
				return graphicalPassword;

		}
		return null;
	}
	public static ThreeDPassword convertToThreeDPassword(ThreeDPasswordDto threeDPasswordDto) {

		ThreeDPassword threeDPassword = null;
		if (threeDPasswordDto != null) {


			threeDPassword = new ThreeDPassword();
			threeDPassword.setUserName(threeDPasswordDto.getUserName());

			threeDPassword.setPassword(new JSONArray(threeDPasswordDto.getPassword()).toString());
			return threeDPassword;

		}
		return null;
	}
	public static ExecutionTime convertToTextLoginTime(ExecutionTimeDto executionTimeDto) {

		ExecutionTime executionTime = null;
		if (executionTimeDto != null) {

			executionTime = new ExecutionTime();
			executionTime.setId(executionTimeDto.getId());
			executionTime.setTime(executionTimeDto.getTime());
			return executionTime;
		}
		return null;
	}


}
