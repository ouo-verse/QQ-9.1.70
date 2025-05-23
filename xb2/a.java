package xb2;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    public static String a(MsgRecord msgRecord) {
        ArkElement arkElement;
        ArrayList<MsgElement> elements = msgRecord.getElements();
        if (elements == null || elements.size() <= 0 || (arkElement = elements.get(0).getArkElement()) == null) {
            return null;
        }
        String bytesData = arkElement.getBytesData();
        if (TextUtils.isEmpty(bytesData)) {
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(bytesData).optJSONObject(PublicAccountMessageUtilImpl.META_NAME).optJSONObject("singlePic").optJSONArray("singlePicItems");
            if (optJSONArray.length() <= 0) {
                return "";
            }
            return optJSONArray.getJSONObject(0).optString("jumpUrl1");
        } catch (JSONException e16) {
            e16.printStackTrace();
            QLog.e("ChatMessageHelper", 4, e16, new Object[0]);
            return "";
        }
    }
}
