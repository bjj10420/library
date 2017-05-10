

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 FILE 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						








						/**
						 * 리소스내의 파일이름을 가지고 아이디를 찾아주는 함수
						 * 
						 * @LastModifyDate : 2017. 01. 19
						 * @LastModifier : JJBAE
						 * @LastVersion : 1.0 2017. 01. 19. JJBAE
						 * @param name
						 * @param mContext
						 */
						public int findIdByFileName(String name, Context mContext) {
							CommonUtils.printDebugLog("GuideManager findIdByName name=" + name);
					
							Resources res = mContext.getResources();
							int id = res.getIdentifier(name, "id", mContext.getPackageName());
					
							return id;
							
						}









					}
