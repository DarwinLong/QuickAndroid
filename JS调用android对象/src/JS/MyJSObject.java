package JS;

import android.content.Context;
import android.widget.Toast;

public class MyJSObject {

	private Context mContext;

	public MyJSObject(Context context) {
		mContext = context;
	}

	public void sayHaHa(String str) {
		Toast.makeText(mContext, str+"  ,¹þ¹þ£¬ÄãºÃ£¡", 1).show();

	}

}
