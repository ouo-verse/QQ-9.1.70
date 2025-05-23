package pu;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f427377b = {2, 1, 8, 4};

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f427378a = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: e, reason: collision with root package name */
        public static final a f427379e = new a();

        /* renamed from: a, reason: collision with root package name */
        public long f427380a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f427381b;

        /* renamed from: c, reason: collision with root package name */
        public int f427382c = 1280;

        /* renamed from: d, reason: collision with root package name */
        public int f427383d = 720;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("ChipAbilityInfo{");
            stringBuffer.append("mChipPowerMark = '");
            stringBuffer.append(d.c(this.f427380a));
            stringBuffer.append('\'');
            stringBuffer.append("mPowerSupport = '");
            stringBuffer.append(this.f427381b);
            stringBuffer.append('\'');
            stringBuffer.append("mMaxWidth = '");
            stringBuffer.append(this.f427382c);
            stringBuffer.append('\'');
            stringBuffer.append("mMaxHeight = '");
            stringBuffer.append(this.f427383d);
            stringBuffer.append('\'');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    private void b(a aVar) {
        Iterator<a> it = this.f427378a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f427380a == aVar.f427380a) {
                next.f427381b = aVar.f427381b;
                next.f427383d = aVar.f427383d;
                next.f427382c = aVar.f427382c;
                return;
            }
        }
        this.f427378a.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(long j3) {
        if (1 == j3) {
            return "h264_encode";
        }
        if (4 == j3) {
            return "h265_encode";
        }
        if (2 == j3) {
            return "h264_decode";
        }
        if (8 == j3) {
            return "h265_decode";
        }
        return "";
    }

    private static long d(String str) {
        if ("h264_encode".equalsIgnoreCase(str)) {
            return 1L;
        }
        if ("h265_encode".equalsIgnoreCase(str)) {
            return 4L;
        }
        if ("h264_decode".equalsIgnoreCase(str)) {
            return 2L;
        }
        if ("h265_decode".equalsIgnoreCase(str)) {
            return 8L;
        }
        return 0L;
    }

    public static d f(String str) {
        int length;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            JSONArray jSONArray = jSONObject.getJSONArray("cpuConfig");
            if (jSONObject.has("cpuConfig") && (length = jSONArray.length()) > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    a aVar = new a();
                    if (jSONObject2.has("descriptionName")) {
                        aVar.f427380a = d(jSONObject2.optString("descriptionName"));
                    }
                    if (jSONObject2.has(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT)) {
                        aVar.f427381b = jSONObject2.optBoolean(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
                    }
                    if (jSONObject2.has("max_width")) {
                        aVar.f427382c = jSONObject2.optInt("max_width");
                    }
                    if (jSONObject2.has("max_height")) {
                        aVar.f427383d = jSONObject2.optInt("max_height");
                    }
                    dVar.b(aVar);
                    if (QLog.isColorLevel()) {
                        QLog.d("MediaCodecChipConfigInfo", 2, "MediaCodecChipConfigInfo parseJson index: " + i3 + "," + aVar.toString());
                    }
                }
            }
            return dVar;
        } catch (Exception e16) {
            QLog.d("MediaCodecChipConfigInfo", 1, String.format("parseJson, Exception\n%s", e16));
            return null;
        }
    }

    public ArrayList<a> e() {
        return this.f427378a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("MediaCodecChipConfigInfo{");
        stringBuffer.append("content = '");
        stringBuffer.append(Arrays.toString(this.f427378a.toArray()));
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
