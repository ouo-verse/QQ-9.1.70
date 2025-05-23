package r62;

import android.text.TextUtils;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import f62.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f430837a;

    public b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                this.f430837a = new JSONObject();
            } else {
                this.f430837a = new JSONObject(str);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    protected void a(String str, Object obj) {
        try {
            this.f430837a.put(str, obj);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public String b() {
        return this.f430837a.toString();
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final b f430838a;

        public a(String str) {
            this.f430838a = new b(str);
        }

        public static int l(int i3) {
            if (i3 == 1004) {
                return 2;
            }
            return 1;
        }

        @Override // f62.c
        public String a() {
            return g().b();
        }

        public a d(int i3) {
            this.f430838a.a("actual_height", Integer.valueOf(i3));
            return this;
        }

        public a e(int i3) {
            this.f430838a.a("actual_width", Integer.valueOf(i3));
            return this;
        }

        public a f(long j3) {
            this.f430838a.a("algorithm_id", Long.valueOf(j3));
            return this;
        }

        public b g() {
            return this.f430838a;
        }

        public a h(int i3) {
            this.f430838a.a("channel_id", Integer.valueOf(i3));
            return this;
        }

        public a i(long j3) {
            this.f430838a.a("current_duration", Long.valueOf(j3));
            return this;
        }

        public a j(int i3) {
            this.f430838a.a(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, Integer.valueOf(l(i3)));
            return this;
        }

        public a k(boolean z16) {
            String str;
            b bVar = this.f430838a;
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            bVar.a(QCircleDaTongConstant.ElementParamValue.MEDAL_FANS, str);
            return this;
        }

        @Override // f62.c
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public a b(boolean z16) {
            this.f430838a.a("is_play", Integer.valueOf(z16 ? 1 : 0));
            return this;
        }

        public a n(int i3) {
            this.f430838a.a("issued_height", Integer.valueOf(i3));
            return this;
        }

        public a o(int i3) {
            this.f430838a.a("issued_width", Integer.valueOf(i3));
            return this;
        }

        public a p(int i3) {
            this.f430838a.a("play_index", Integer.valueOf(i3));
            return this;
        }

        @Override // f62.c
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public a put(String str, Object obj) {
            this.f430838a.a(str, obj);
            return this;
        }

        @Override // f62.c
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public a c(String str) {
            this.f430838a.a("rowkey", str);
            return this;
        }

        public a s(int i3) {
            this.f430838a.a("strategy_id", Integer.valueOf(i3));
            return this;
        }

        public a t(long j3) {
            this.f430838a.a("video_duration", Long.valueOf(j3));
            return this;
        }

        public a v(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f430838a.a("video_session_id", str);
            }
            return this;
        }

        public a x(long j3) {
            this.f430838a.a("watch_duration", Long.valueOf(j3));
            return this;
        }

        public a(String str, String str2, String str3, String str4) {
            this.f430838a = new b(str, str2, str3, str4);
        }

        public a w(com.tencent.mobileqq.kandian.glue.video.b bVar) {
            return this;
        }

        public a u(com.tencent.mobileqq.kandian.glue.video.b bVar, long j3) {
            return this;
        }
    }

    public b(String str, String str2, String str3, String str4) {
        this.f430837a = new JSONObject();
    }
}
