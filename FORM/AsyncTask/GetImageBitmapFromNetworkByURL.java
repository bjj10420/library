	package com.BeezPlanet.bpline.common.task;
	
	import java.net.URL;
	
	import android.graphics.Bitmap;
	import android.graphics.BitmapFactory;
	import android.os.AsyncTask;
	
	import com.BeezPlanet.bpline.application.BPLineApplication;
	import com.BeezPlanet.bpline.common.utils.CommonUtils;
	
	public class GetImageBitmapFromNetworkByURL extends AsyncTask<String, Integer, Bitmap> {
	
		private AsyncTaskCallback<Bitmap> mCallback;
		
		public GetImageBitmapFromNetworkByURL(AsyncTaskCallback<Bitmap> callback)
		{
			
			mCallback = callback;
			
		}
		
		@Override
		protected Bitmap doInBackground(String... params)
		{		
			
			URL url = null;
			
			try
			{
				
				String bannerImageUrl = params[0];
				
				Bitmap image = null;
							
				url = new URL(bannerImageUrl);
					
				if(url != null) {
						
				image = BitmapFactory.decodeStream(url.openStream());
						
				// 비트맵을 어플리케이션 객체에 넣어둔다
				BPLineApplication.putBannerImageIntoMap(bannerImageUrl, image);
						
			}
						
				return image;
				
			}
	
			catch (Exception e)
			{
				
				CommonUtils.printDebugStackTrace(e);
				
			}
			
			return null;
			
		}
		
		@Override
		protected void onPostExecute(Bitmap result)
		{
			
			try {
				
				if(mCallback != null) {
					
					mCallback.postExecute(result);
					
				}
				
				super.onPostExecute(result);
				
			} catch (Exception e) {
				
				CommonUtils.printDebugStackTrace(e);
				
			}
		}
	}