$(document)
			.ready(
					function() {
						$('#signup')
								.bootstrapValidator(
										{
											message : 'This value is not valid',
											feedbackIcons : {
												valid : 'glyphicon glyphicon-ok',
												invalid : 'glyphicon glyphicon-remove',
												validating : 'glyphicon glyphicon-refresh'
											},
											fields : {
												firstName : {
													message : 'The firstName is not valid',
													validators : {
														notEmpty : {
															message : 'The firstName is required and cannot be empty'
														},
														stringLength : {
															min : 4,
															max : 15,
															message : 'The firstName must be more than 3 and less than 15 characters long'
														},
														regexp : {
															regexp : /^[a-zA-Z]+$/,
															message : 'The firstName can only consist of alphabets'
														}
													}
												},
												lastName : {
													message : 'The lastName is not valid',
													validators : {
														notEmpty : {
															message : 'The lastName is required and cannot be empty'
														},
														stringLength : {
															min : 4,
															max : 15,
															message : 'The lastName must be more than 3 and less than 15 characters long'
														},
														regexp : {
															regexp : /^[a-zA-Z]+$/,
															message : 'The lastName can only consist of alphabets'
														}
													}
												},
												emailId : {
													message : 'The emailId is not valid',
													validators : {
														notEmpty : {
															message : 'The emailId is required and cannot be empty'
														},
														regexp : {
															regexp : /^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$/,
															message : 'The emailId is invalid'
														}
													}
												},
												password : {
													validators : {
														notEmpty : {
															message : 'The password is required and cannot be empty'
														},
														stringLength : {
															min : 6,
															max : 12,
															message : 'The password must be more than 5 and less than 12 characters long'
														},
														regexp : {
															regexp : /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/,
															message : 'The password should consist of atleast 1 uppercase, 1 lowercase, 1 digit and 1 special character'
														}
														}
													},
												balance : {
													validators : {
														notEmpty : {
															message : 'The balance is required and cannot be empty'
														},
														stringLength : {
															min: 3,
															max : 5,
															message : 'Can only deposit amount between $100 and $99999 at the time of opening an account'
														},
														regexp : {
															regexp : /^[0-9]*$/,
															message : 'The balance should consist of only digits'
														}
														}
													}
												}
											}
										);
					});/**
 * 
 */