package vk2;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$QQWalletAioElem;
import tencent.im.qqwallet.qqwalletaio_resv$Payer;
import tencent.im.qqwallet.qqwalletaio_resv$qqwalletaio_elem_resv;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    public List<a> A;
    public int B;
    public int D;
    public int E;

    /* renamed from: a, reason: collision with root package name */
    public int f441763a;

    /* renamed from: b, reason: collision with root package name */
    public int f441764b;

    /* renamed from: c, reason: collision with root package name */
    public String f441765c;

    /* renamed from: d, reason: collision with root package name */
    public String f441766d;

    /* renamed from: e, reason: collision with root package name */
    public String f441767e;

    /* renamed from: f, reason: collision with root package name */
    public String f441768f;

    /* renamed from: g, reason: collision with root package name */
    public String f441769g;

    /* renamed from: h, reason: collision with root package name */
    public String f441770h;

    /* renamed from: i, reason: collision with root package name */
    public int f441771i;

    /* renamed from: j, reason: collision with root package name */
    public int f441772j;

    /* renamed from: k, reason: collision with root package name */
    public String f441773k;

    /* renamed from: l, reason: collision with root package name */
    public String f441774l;

    /* renamed from: m, reason: collision with root package name */
    public String f441775m;

    /* renamed from: n, reason: collision with root package name */
    public String f441776n;

    /* renamed from: o, reason: collision with root package name */
    public int f441777o;

    /* renamed from: p, reason: collision with root package name */
    public int f441778p;

    /* renamed from: q, reason: collision with root package name */
    @Deprecated
    public String f441779q;

    /* renamed from: r, reason: collision with root package name */
    @Deprecated
    public String f441780r;

    /* renamed from: s, reason: collision with root package name */
    @Deprecated
    public String f441781s;

    /* renamed from: t, reason: collision with root package name */
    public int f441782t;

    /* renamed from: u, reason: collision with root package name */
    public int f441783u;

    /* renamed from: v, reason: collision with root package name */
    public int f441784v;

    /* renamed from: w, reason: collision with root package name */
    public String f441785w;

    /* renamed from: x, reason: collision with root package name */
    public int f441786x;

    /* renamed from: y, reason: collision with root package name */
    public int f441787y;

    /* renamed from: z, reason: collision with root package name */
    public int f441788z;
    public int C = 0;
    public String F = "";

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f441789a;

        /* renamed from: b, reason: collision with root package name */
        int f441790b;
    }

    public b() {
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<a> list = this.A;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < this.A.size(); i3++) {
                    a aVar = this.A.get(i3);
                    if (aVar != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("uin", aVar.f441789a);
                        jSONObject2.put("amount", aVar.f441790b);
                        jSONArray.mo162put(jSONObject2);
                    }
                }
                jSONObject.put("payers", jSONArray);
            }
        } catch (JSONException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.e("QQWalletBaseMsgElem", 1, "error msg in qqpay-api module: ", e16);
            }
        }
        return jSONObject.toString();
    }

    public void b(byte[] bArr) {
        try {
            qqwalletaio_resv$qqwalletaio_elem_resv qqwalletaio_resv_qqwalletaio_elem_resv = new qqwalletaio_resv$qqwalletaio_elem_resv();
            qqwalletaio_resv_qqwalletaio_elem_resv.mergeFrom(bArr);
            if (qqwalletaio_resv_qqwalletaio_elem_resv.sound_record_duration.has()) {
                this.f441782t = qqwalletaio_resv_qqwalletaio_elem_resv.sound_record_duration.get();
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.uint32_resource_type.has()) {
                this.f441783u = qqwalletaio_resv_qqwalletaio_elem_resv.uint32_resource_type.get();
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.uint32_skin_id.has()) {
                this.f441784v = qqwalletaio_resv_qqwalletaio_elem_resv.uint32_skin_id.get();
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.bytes_outer_skin_id.has()) {
                this.f441785w = qqwalletaio_resv_qqwalletaio_elem_resv.bytes_outer_skin_id.get().toStringUtf8();
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.uint32_skin_from.has()) {
                this.f441786x = qqwalletaio_resv_qqwalletaio_elem_resv.uint32_skin_from.get();
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.uint32_effects_id.has()) {
                this.f441787y = qqwalletaio_resv_qqwalletaio_elem_resv.uint32_effects_id.get();
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.int32_special_pop_id.has()) {
                this.f441788z = qqwalletaio_resv_qqwalletaio_elem_resv.int32_special_pop_id.get();
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.rpt_payer.has()) {
                List<qqwalletaio_resv$Payer> list = qqwalletaio_resv_qqwalletaio_elem_resv.rpt_payer.get();
                this.A = new ArrayList();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    qqwalletaio_resv$Payer qqwalletaio_resv_payer = list.get(i3);
                    if (qqwalletaio_resv_payer != null) {
                        a aVar = new a();
                        if (qqwalletaio_resv_payer.uint64_uin.has()) {
                            aVar.f441789a = qqwalletaio_resv_payer.uint64_uin.get();
                        }
                        if (qqwalletaio_resv_payer.uint32_amount.has()) {
                            aVar.f441790b = qqwalletaio_resv_payer.uint32_amount.get();
                        }
                        this.A.add(aVar);
                    }
                }
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.uint32_subjectid.has()) {
                this.B = qqwalletaio_resv_qqwalletaio_elem_resv.uint32_subjectid.get();
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.uint32_hb_from.has()) {
                this.C = qqwalletaio_resv_qqwalletaio_elem_resv.uint32_hb_from.get();
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.uint32_song_id.has()) {
                this.D = qqwalletaio_resv_qqwalletaio_elem_resv.uint32_song_id.get();
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.uint32_song_flag.has()) {
                this.E = qqwalletaio_resv_qqwalletaio_elem_resv.uint32_song_flag.get();
            }
            if (qqwalletaio_resv_qqwalletaio_elem_resv.bytes_idiom_alpha.has()) {
                this.F = qqwalletaio_resv_qqwalletaio_elem_resv.bytes_idiom_alpha.get().toStringUtf8();
            }
        } catch (Throwable th5) {
            QLog.e("QQWalletBaseMsgElem", 1, "error msg in qqpay-api module: ", th5);
        }
    }

    public void c(String str) {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("payers");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.A = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.f441789a = optJSONObject.optLong("uin");
                        aVar.f441790b = optJSONObject.optInt("amount");
                        this.A.add(aVar);
                    }
                }
            }
        } catch (JSONException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.e("QQWalletBaseMsgElem", 1, "error msg in qqpay-api module: ", e16);
            }
        }
    }

    public String toString() {
        return "soundRecordDuration=" + this.f441782t + ",resourceType=" + this.f441783u + ",themeId=" + this.B + ",skinId=" + this.f441784v + ",effectsId=" + this.f441787y + ",special_pop_id=" + this.f441788z;
    }

    public b(im_msg_body$QQWalletAioElem im_msg_body_qqwalletaioelem) {
        if (im_msg_body_qqwalletaioelem == null) {
            return;
        }
        this.f441763a = im_msg_body_qqwalletaioelem.uint32_background.get();
        this.f441764b = im_msg_body_qqwalletaioelem.uint32_icon.get();
        this.f441765c = im_msg_body_qqwalletaioelem.bytes_title.get().toStringUtf8();
        this.f441766d = im_msg_body_qqwalletaioelem.bytes_subtitle.get().toStringUtf8();
        this.f441767e = im_msg_body_qqwalletaioelem.bytes_content.get().toStringUtf8();
        this.f441768f = im_msg_body_qqwalletaioelem.bytes_linkurl.get().toStringUtf8();
        this.f441769g = im_msg_body_qqwalletaioelem.bytes_blackstripe.get().toStringUtf8();
        String stringUtf8 = im_msg_body_qqwalletaioelem.bytes_notice.get().toStringUtf8();
        this.f441770h = stringUtf8;
        if (this.f441768f == null) {
            this.f441768f = "";
        }
        if (this.f441769g == null) {
            this.f441769g = "";
        }
        if (stringUtf8 == null) {
            this.f441770h = "";
        }
        this.f441763a |= -16777216;
        if (im_msg_body_qqwalletaioelem.uint32_title_color.has()) {
            this.f441771i = im_msg_body_qqwalletaioelem.uint32_title_color.get() | (-16777216);
        } else {
            this.f441771i = -1;
        }
        if (im_msg_body_qqwalletaioelem.uint32_subtitle_color.has()) {
            this.f441772j = im_msg_body_qqwalletaioelem.uint32_subtitle_color.get() | (-16777216);
        } else {
            this.f441772j = -1;
        }
        if (im_msg_body_qqwalletaioelem.bytes_actions_priority.has()) {
            this.f441773k = im_msg_body_qqwalletaioelem.bytes_actions_priority.get().toStringUtf8();
        } else {
            this.f441773k = "";
        }
        if (im_msg_body_qqwalletaioelem.bytes_jump_url.has()) {
            this.f441774l = im_msg_body_qqwalletaioelem.bytes_jump_url.get().toStringUtf8();
        } else {
            this.f441774l = "";
        }
        if (im_msg_body_qqwalletaioelem.bytes_native_android.has()) {
            this.f441775m = im_msg_body_qqwalletaioelem.bytes_native_android.get().toStringUtf8();
        } else {
            this.f441775m = "";
        }
        if (im_msg_body_qqwalletaioelem.bytes_iconurl.has()) {
            this.f441776n = im_msg_body_qqwalletaioelem.bytes_iconurl.get().toStringUtf8();
        } else {
            this.f441776n = "";
        }
        if (im_msg_body_qqwalletaioelem.uint32_content_color.has()) {
            this.f441777o = im_msg_body_qqwalletaioelem.uint32_content_color.get() | (-16777216);
        } else {
            this.f441777o = -1;
        }
        if (im_msg_body_qqwalletaioelem.uint32_content_bgcolor.has()) {
            this.f441778p = im_msg_body_qqwalletaioelem.uint32_content_bgcolor.get() | (-16777216);
        } else {
            this.f441778p = -1;
        }
        if (im_msg_body_qqwalletaioelem.bytes_aio_image_left.has()) {
            this.f441779q = im_msg_body_qqwalletaioelem.bytes_aio_image_left.get().toStringUtf8();
        } else {
            this.f441779q = "";
        }
        if (im_msg_body_qqwalletaioelem.bytes_aio_image_right.has()) {
            this.f441780r = im_msg_body_qqwalletaioelem.bytes_aio_image_right.get().toStringUtf8();
        } else {
            this.f441780r = "";
        }
        if (im_msg_body_qqwalletaioelem.bytes_cft_image.has()) {
            this.f441781s = im_msg_body_qqwalletaioelem.bytes_cft_image.get().toStringUtf8();
        } else {
            this.f441781s = "";
        }
        this.f441782t = 12000;
        if (im_msg_body_qqwalletaioelem.bytes_pb_reserve.has()) {
            b(im_msg_body_qqwalletaioelem.bytes_pb_reserve.get().toByteArray());
        }
    }
}
