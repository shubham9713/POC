package com.shubham.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnlockAccount {

	private String email;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;
}
