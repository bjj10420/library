

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 VIEW 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
					









						/**
						 * 필드 ViewMap에 담겨있는 모든 가이드뷰의 폰트를 변경
						 * @param mContext
						 */
						private void setAllViewFont(Context context) {


							for(String key : ViewMap.keySet()){
							

							CommonUtils.setFont(context, ViewMap.get(key));
								
							
							}
							
						}

					
					
					
					
					
					
					
				
						/**
						 * 한 부모 뷰내의 모든 텍스트뷰의 폰트를 변경
						 * @param context
						 * @param v
						 */
						public static void setFont(final Context context, final View v) {
						    try {
						        if (v instanceof ViewGroup) {
						            ViewGroup vg = (ViewGroup) v;
						            for (int i = 0; i < vg.getChildCount(); i++) {
						                View child = vg.getChildAt(i);
						                setFont(context, child);
						         }
						        } else if (v instanceof TextView ) {
						            ((TextView) v).setTypeface(getTypefaceFromContext(context));
						        }
						    } catch (Exception e) {
						 }
						 }

					
					
					
					
					
					
					
				

						/**
						 * 해당 컨테이너의 자식중에 선택되어있는 뷰를 리턴
						 * @param transportSelectContents
						 */
						public static View getSelectedChildeView(LinearLayout transportSelectContents) {
 														
							
							for(int i = 0 ; i < transportSelectContents.getChildCount() ; i++ ) {
								
								View view = transportSelectContents.getChildAt(i);
								if(view.isSelected()){
						 
									 return view;
										
								} 
							}
							
							return null;
							
							
						}

					
					
					
					
					
					
					
				


						/**
						* context와 resourceId를 가지고 뷰를 구해주는 함수
						*
						* @LastModifyDate :  2017. 1. 23.
						* @LastModifier : JJBAE
						* @LastVersion : 1.0  2017. 1. 23. JJBAE
						* @param context
						* @param resouceId
						*/
						public static View getViewById(Context context,int resourceId){
							
							View view = ((Activity) context).findViewById(resourceId);
									
							return view;		
							
						}










						/**
						 * 뷰맵안에 있는 모든 뷰에 클릭 이벤트를 설정하고 태그를 걸어둔다
						 *
						 * @LastModifyDate : 2017. 1. 19.
						 * @LastModifier : JJBAE
						 * @LastVersion : 1.0 2017. 1. 19. JJBAE
						 * @param viewMap
						 * @param clickListener
						 */
						public void setViewMapClickEventWithTag(Map<String, View> viewMap, OnClickListener clickListener) {
							CommonUtils.printDebugLog("GuideManager setViewMapClickEventWithTag");
					
							for (String key : viewMap.keySet()) {
					
								viewMap.get(key).setOnClickListener(clickListener);
								viewMap.get(key).setTag(key);
					
							}
						}
					}
