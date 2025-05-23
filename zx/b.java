package zx;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f453627a;

    /* renamed from: b, reason: collision with root package name */
    public String f453628b;

    /* renamed from: c, reason: collision with root package name */
    public String f453629c;

    /* renamed from: d, reason: collision with root package name */
    public c f453630d;

    /* renamed from: e, reason: collision with root package name */
    public d f453631e;

    /* renamed from: f, reason: collision with root package name */
    public e f453632f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f453633g;

    private void c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("title")) {
            this.f453627a = jSONObject.getString("title");
        }
        if (jSONObject.has("video")) {
            this.f453628b = jSONObject.getString("video");
        }
        if (jSONObject.has("picture")) {
            this.f453629c = jSONObject.getString("picture");
        }
        if (jSONObject.has("picture_attr")) {
            d(jSONObject.getJSONObject("picture_attr"));
        }
        if (jSONObject.has("video_attr")) {
            e(jSONObject.getJSONObject("video_attr"));
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("msg")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("msg");
                if (jSONObject2.has(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                    JSONArray jSONArray = jSONObject2.getJSONArray(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME);
                    int length = jSONArray == null ? 0 : jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i3);
                        int length2 = jSONArray2 == null ? 0 : jSONArray2.length();
                        for (int i16 = 0; i16 < length2; i16++) {
                            c(jSONArray2.getJSONObject(i16));
                        }
                    }
                }
            }
            if (jSONObject.has("msg_attr")) {
                a(jSONObject.getJSONObject("msg_attr"));
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("DynamicInfo", 2, "DynamicInfo Exception:" + e16.getMessage());
            }
        }
    }

    private void a(JSONObject jSONObject) throws JSONException {
        this.f453630d = null;
        if (jSONObject != null) {
            this.f453630d = new c();
            if (jSONObject.has(IPublicAccountImageCollectionMainActivity.ARTICLE_ID)) {
                this.f453630d.f453634a = jSONObject.getLong(IPublicAccountImageCollectionMainActivity.ARTICLE_ID);
            }
            if (jSONObject.has("id")) {
                this.f453630d.f453635b = jSONObject.getLong("id");
            }
            if (jSONObject.has("jumpurl")) {
                this.f453630d.f453636c = jSONObject.getString("jumpurl");
            }
            if (jSONObject.has(AppConstants.Key.COLUMN_MSG_TYPE)) {
                this.f453630d.f453637d = jSONObject.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
            }
            if (jSONObject.has("tasktype")) {
                this.f453630d.f453638e = jSONObject.getInt("tasktype");
            }
            if (jSONObject.has("time")) {
                this.f453630d.f453639f = jSONObject.getLong("time");
            }
            if (jSONObject.has("uniqueid")) {
                this.f453630d.f453640g = jSONObject.getLong("uniqueid");
            }
            if (jSONObject.has("rowkey")) {
                this.f453630d.f453641h = jSONObject.getString("rowkey");
            }
        }
    }

    private void d(JSONObject jSONObject) throws JSONException {
        this.f453631e = null;
        if (jSONObject != null) {
            this.f453631e = new d();
            if (jSONObject.has("cover")) {
                this.f453631e.f453642a = jSONObject.getString("cover");
            }
            if (jSONObject.has("cover_orig")) {
                this.f453631e.f453644c = jSONObject.getString("cover_orig");
            }
            if (jSONObject.has(NtFaceConstant.LARGE)) {
                this.f453631e.f453643b = jSONObject.getInt(NtFaceConstant.LARGE);
            }
        }
    }

    private void e(JSONObject jSONObject) throws JSONException {
        this.f453632f = null;
        if (jSONObject != null) {
            this.f453632f = new e();
            if (jSONObject.has("busitype")) {
                this.f453632f.f453645a = jSONObject.getInt("busitype");
            }
            if (jSONObject.has("cover")) {
                this.f453632f.f453646b = jSONObject.getString("cover");
            }
            if (jSONObject.has("cover_orig")) {
                this.f453632f.f453653i = jSONObject.getString("cover_orig");
            }
            if (jSONObject.has("fulltime")) {
                this.f453632f.f453648d = jSONObject.getInt("fulltime");
            }
            if (jSONObject.has("h5url")) {
                this.f453632f.f453647c = jSONObject.getString("h5url");
            }
            if (jSONObject.has("preheight")) {
                this.f453632f.f453649e = jSONObject.getInt("preheight");
            }
            if (jSONObject.has("prewidth")) {
                this.f453632f.f453650f = jSONObject.getInt("prewidth");
            }
            if (jSONObject.has("vid")) {
                this.f453632f.f453651g = jSONObject.getString("vid");
            }
            if (jSONObject.has(NtFaceConstant.LARGE)) {
                this.f453632f.f453652h = jSONObject.getInt(NtFaceConstant.LARGE);
            }
        }
    }
}
