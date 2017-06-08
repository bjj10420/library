

					
					
					
					
					
					
					
					
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










						// RelativeLayout의 자식속성을 변경
						public static void setRelativeLayoutChildAttribute(View child, int attribute){
							
							RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) child.getLayoutParams();
							
							params.addRule(attribute);
							child.setLayoutParams(params); 
							
						}
						









						/**
						 * 옵션으로 빈 뷰를 만들어 생성
						 * @param context
						 * @param height
						 * @param layoutId
						 * @return
						 */
						public static View makeAViewWithOption(Context context, int height, int layoutId){
							
							LayoutInflater inflater = LayoutInflater.from(context);
							
							View newView = inflater.inflate(R.layout.empty_layout, null);
							
							LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
							
							params.height =  (int) UnitUtils.convertDpToPixel(height); 
							
							newView.setLayoutParams(params);
							
							return newView;
							
						}











						/**
						 * 옵션으로 텍스트뷰를 만들어 부모뷰에 추가
						 * @param context
						 * @param parentView
						 * @param textContent
						 * @param height
						 * @param textSize
						 */
						public static void makeATextViewAndPutSomewhere(Context context, LinearLayout parentView, String textContent, int height, int textSize, String textColor){
							
							TextView textView = new TextView(context);
							textView.setTypeface(CommonUtils.getTypefaceFromContext(context));
						        android.widget.LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
					        LayoutParams.WRAP_CONTENT, (int) UnitUtils.convertDpToPixel(height)); 
						        textView.setTextSize(textSize);
							textView.setText(textContent);
							textView.setGravity(Gravity.CENTER_VERTICAL);
							textView.setLayoutParams(lp);
							textView.setTextColor(Color.parseColor(textColor));
							parentView.addView(textView);
						
						}











						/**
						 * 해당 뷰의 마진을 변경해준다
						 * @param contentView
						 * @param marginValue
						 */
						public static void setLayoutMargin(View contentView, int marginValue){

							// 부모 뷰가 Frame 레이아웃
							if(((ViewGroup) contentView.getParent()).getParent() instanceof  FrameLayout) {

								FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) contentView.getLayoutParams();
								param.topMargin = (int) UnitUtils.convertDpToPixel(marginValue);
								contentView.setLayoutParams(param);

							}
							// 부모 뷰가 Relative 레이아웃
							else if(((ViewGroup) contentView.getParent()).getParent() instanceof  RelativeLayout) {

								RelativeLayout.LayoutParams param = (RelativeLayout.LayoutParams) contentView.getLayoutParams();
								param.topMargin = (int) UnitUtils.convertDpToPixel(marginValue);
								contentView.setLayoutParams(param);

							}
							// 부모 뷰가 Linear 레이아웃
							else if(((ViewGroup) contentView.getParent()).getParent() instanceof  LinearLayout) {

								LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) contentView.getLayoutParams();
								param.topMargin = (int) UnitUtils.convertDpToPixel(marginValue);
								contentView.setLayoutParams(param);

							}
						}						
					}
