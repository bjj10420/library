

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 WEBVIEW 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
		



		




						/*************************************************************************************
						 * setWebViewContents : WebView를 안드로이드 버전에 맞게 설정
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2015. 12. 11.
						 * @param webView
						 *            설정할 웹뷰
						 * @param contents
						 *            웹뷰가 표시할 컨텐츠
						 * @수정이력 1. ...
						 */
						public static void setWebViewContents(WebView webView, String contents) {
							try {
								// 컨텐츠: 한글 깨짐을 방지하기 위해 SDK 버전 체크 후 컨텐츠 설정
								int SDK_VER = Build.VERSION.SDK_INT;
								if (SDK_VER <= Build.VERSION_CODES.GINGERBREAD) { // 진저브레드 이하(4.0
																					// 이하)
									webView.loadData(contents, "text/html", "UTF-8");
								} else { // 젤리빈 이후 버전(4.1 이상)
									webView.loadData(contents, "text/html; charset=UTF-8", null);
								}
							} catch (Exception e) {
								printDebugStackTrace(e);
							}
						}
					



		





						/*************************************************************************************
						 * setWebViewContentsWithBaseURL : WebView를 안드로이드 버전에 맞게 설정
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2015. 12. 11.
						 * @param webView
						 *            설정할 웹뷰
						 * @param contents
						 *            웹뷰가 표시할 컨텐츠
						 * @수정이력 1. ...
						 */
						public static void setWebViewContentsWithBaseURL(WebView webView, String contents) {
							try {
								webView.loadDataWithBaseURL("", contents, "text/html", "UTF-8", null);
							} catch (Exception e) {
								printDebugStackTrace(e);
							}
						}
					



		






						/**
						 * 웹뷰 URL 로드 및 설정
						 */
						private void setWebView(String content) {

							CommonUtils.printDebugLog("BPLinePartnerServiceActivity setWebView content = " + content);
							
							WebView partnerServiceContent = (WebView) findViewById(R.id.partner_service_content);
				 			
							partnerServiceContent.setHorizontalScrollBarEnabled(true);
							
							partnerServiceContent.setVerticalScrollBarEnabled(true);
							
							partnerServiceContent.getSettings().setJavaScriptEnabled(true);
							
							//현재 창으로 셋팅
							partnerServiceContent.setWebViewClient(new WebViewClient(){

								@Override
								public boolean shouldOverrideUrlLoading(WebView view, String url) {
						
									setTitle(url);
									
									return false;
							
								}
								
								
								
							});
							
							partnerServiceContent.setOnLongClickListener(new OnLongClickListener()
							{				
								@Override
								public boolean onLongClick(View v)
								{
									
									return true;
									
								}
							});

							partnerServiceContent.loadUrl(content);

						}
											



		






						/**
						 * 웹뷰 데이터 로드 및 설정
						 */
						private void setWebView(String content) {

							WebView eventContent = (WebView) findViewById(R.id.event_content);
				 			
							eventContent.setHorizontalScrollBarEnabled(true);
							
							eventContent.setVerticalScrollBarEnabled(true);
							
							eventContent.getSettings().setJavaScriptEnabled(true);
							
							eventContent.setOnLongClickListener(new OnLongClickListener()
							{				
								@Override
								public boolean onLongClick(View v)
								{
									
									return true;
									
								}
							});
							
							// 컨텐츠: 한글 깨짐을 방지하기 위해 SDK 버전 체크 후 컨텐츠 설정
							int SDK_VER = Build.VERSION.SDK_INT;			
							
							if(SDK_VER <= Build.VERSION_CODES.GINGERBREAD) {	// 진저브레드 이하(4.0 이하)
								
								eventContent.loadData(content, "text/html", "UTF-8");
								
							} else {	// 젤리빈 이후 버전(4.1 이상)
								
								eventContent.loadData(content, "text/html; charset=UTF-8", null);
								
							}
							
						}




		






					}
