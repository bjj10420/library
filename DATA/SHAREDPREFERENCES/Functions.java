

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 SHAREDPREFERENCES 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						








						/**
						* context로 내부 저장소 객체를 가지고 온다
						*
						* @LastModifyDate :  2017. 1. 23.
						* @LastModifier : JJBAE
						* @LastVersion : 1.0  2017. 1. 23. JJBAE
						* @param context
						* @return
						*/
						public static SharedPreferences getSharedPreferences(Context context, String tagName){
							
							SharedPreferences sp = context.getSharedPreferences(tagName, context.MODE_PRIVATE);
									
							return sp;
							
						}










		
						/**
						* 내부 저장소 객체를 업데이트
						*
						* @LastModifyDate :  2017. 1. 19.
						* @LastModifier : JJBAE
						* @LastVersion : 1.0  2017. 1. 19. JJBAE
						* @param mPref
						* @param valueName
						* @param value
						*/
						public static void updateSharedPreferences(SharedPreferences mPref,String valueName, Object value, int valueType){
					 		
							 SharedPreferences.Editor edit = mPref.edit();
							 edit.remove(valueName);
							 
							 // 값의 타입에 따라 업데이트를 해준다
							 switch (valueType) {
							 
							// boolean
							case 0:
								edit.putBoolean(valueName, (Boolean) value);
								break;
					
							// int
							case 1:
								edit.putInt(valueName, (Integer) value);
								break;
					
							// boolean
							case 2:
								edit.putString(valueName, (String) value);
								break;
					 
							 }
							 
							 edit.commit();
						
						}










		
					}
