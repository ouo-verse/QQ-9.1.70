package r94;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import qu4.d;
import qu4.g;
import qu4.i;
import qu4.j;
import qu4.k;
import qu4.l;
import qu4.m;
import qu4.p;
import qu4.q;
import qu4.r;
import tl.h;
import uv4.am;
import uv4.aw;
import uv4.az;
import uv4.be;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\n\u0010\b\u001a\u00020\u0005*\u00020\u0000\u001a\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004*\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\u0000*\u00020\r\u001a\n\u0010\u000f\u001a\u00020\u0000*\u00020\r\u001a\n\u0010\u0011\u001a\u00020\u0000*\u00020\u0010\u001a\n\u0010\u0012\u001a\u00020\u0000*\u00020\u0010\u001a\n\u0010\u0014\u001a\u00020\u0000*\u00020\u0013\u001a\n\u0010\u0015\u001a\u00020\u0000*\u00020\u0013\u001a\n\u0010\u0017\u001a\u00020\u0000*\u00020\u0016\u001a\n\u0010\u0019\u001a\u00020\u0000*\u00020\u0018\u001a\n\u0010\u001b\u001a\u00020\u0000*\u00020\u001a\u001a\n\u0010\u001c\u001a\u00020\u0000*\u00020\u001a\u001a\n\u0010\u001d\u001a\u00020\u0000*\u00020\u0001\u001a\n\u0010\u001e\u001a\u00020\u0000*\u00020\u0001\u001a\n\u0010\u001f\u001a\u00020\u0000*\u00020\u0005\u001a\n\u0010 \u001a\u00020\u0000*\u00020\u0005\u001a\n\u0010\"\u001a\u00020\u0000*\u00020!\u001a\n\u0010#\u001a\u00020\u0000*\u00020!\u001a\n\u0010%\u001a\u00020\u0000*\u00020$\u001a\n\u0010&\u001a\u00020\u0000*\u00020$\u001a\n\u0010(\u001a\u00020\u0000*\u00020'\u001a\n\u0010)\u001a\u00020\u0000*\u00020\t\u001a\n\u0010+\u001a\u00020\u0000*\u00020*\u001a\u0010\u0010.\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020-0,\u001a\n\u0010/\u001a\u00020\u0000*\u00020-\u001a\f\u00101\u001a\u00020\u0000*\u0004\u0018\u000100\u001a\n\u00103\u001a\u00020\u0000*\u000202\u001a\n\u00105\u001a\u00020\u0000*\u000204\u001a\u0018\u00108\u001a\u00020\u0003*\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000202\u0018\u000106\u001a\u0010\u00109\u001a\u00020\u0003*\b\u0012\u0004\u0012\u0002020,\u001a-\u0010?\u001a\u00020>\"\u0004\b\u0000\u0010:*\u00020\u00002\u0006\u0010<\u001a\u00020;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b?\u0010@\u001a\u001a\u0010B\u001a\u00020>*\u00020\u00002\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020A\u00a8\u0006C"}, d2 = {"Lorg/json/JSONObject;", "Lqu4/j;", "e", "Lorg/json/JSONArray;", "", "Lqu4/k;", "g", "(Lorg/json/JSONArray;)[Lqu4/k;", "f", "Lqu4/i;", "d", "(Lorg/json/JSONArray;)[Lqu4/i;", "c", "Lqu4/a;", h.F, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lqu4/c;", "j", BdhLogUtil.LogTag.Tag_Conn, "Lqu4/d;", "k", "D", "Lqu4/l;", "p", "Lqu4/p;", "r", "Lqu4/m;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "G", DomainData.DOMAIN_NAME, "E", "o", UserInfo.SEX_FEMALE, "Lqu4/b;", "i", "B", "Lqu4/q;", ReportConstant.COSTREPORT_PREFIX, "H", "Lqu4/g;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqu4/r;", "t", "", "Luv4/aw;", HippyTKDListViewAdapter.X, "v", "Luv4/am;", "u", "Luv4/az;", "I", "Luv4/be;", "w", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "T", "", "key", HippyControllerProps.ARRAY, "", "b", "(Lorg/json/JSONObject;Ljava/lang/String;[Ljava/lang/Object;)V", "", "a", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {
    public static final JSONObject A(qu4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        qu4.b avatarInfo = aVar.f429572a;
        if (avatarInfo != null) {
            Intrinsics.checkNotNullExpressionValue(avatarInfo, "avatarInfo");
            jSONObject.put("avatar_info", B(avatarInfo));
        }
        j faceInfo = aVar.f429573b;
        if (faceInfo != null) {
            Intrinsics.checkNotNullExpressionValue(faceInfo, "faceInfo");
            jSONObject.put("face_info", E(faceInfo));
        }
        m makeupInfo = aVar.f429574c;
        if (makeupInfo != null) {
            Intrinsics.checkNotNullExpressionValue(makeupInfo, "makeupInfo");
            jSONObject.put("makeup_info", G(makeupInfo));
        }
        qu4.c colorInfo = aVar.f429575d;
        if (colorInfo != null) {
            Intrinsics.checkNotNullExpressionValue(colorInfo, "colorInfo");
            jSONObject.put("color_info", C(colorInfo));
        }
        jSONObject.put("gender", aVar.f429576e);
        return jSONObject;
    }

    public static final JSONObject B(qu4.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", bVar.f429577a);
        JSONArray jSONArray = new JSONArray();
        q[] slotArr = bVar.f429578b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (q it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(H(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        return jSONObject;
    }

    public static final JSONObject C(qu4.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", cVar.f429580a);
        JSONArray jSONArray = new JSONArray();
        d[] slotArr = cVar.f429581b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (d it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(D(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        return jSONObject;
    }

    public static final JSONObject D(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, dVar.f429583a);
        jSONObject.put("color_type", dVar.f429584b);
        return jSONObject;
    }

    public static final JSONObject E(j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", jVar.f429606a);
        JSONArray jSONArray = new JSONArray();
        k[] slotArr = jVar.f429607b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (k it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(F(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        return jSONObject;
    }

    public static final JSONObject F(k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, kVar.f429609a);
        jSONObject.put("item_id", kVar.f429610b);
        return jSONObject;
    }

    public static final JSONObject G(m mVar) {
        Intrinsics.checkNotNullParameter(mVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", mVar.f429620a);
        JSONArray jSONArray = new JSONArray();
        q[] slotArr = mVar.f429621b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (q it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(H(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        return jSONObject;
    }

    public static final JSONObject H(q qVar) {
        Intrinsics.checkNotNullParameter(qVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, qVar.f429639a);
        jSONObject.put("item_id", qVar.f429640b);
        return jSONObject;
    }

    public static final JSONObject I(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, azVar.B);
        jSONObject.put("havingCount", azVar.f440295v);
        jSONObject.put("expireTime", azVar.A);
        be slot = azVar.f440290q;
        if (slot != null) {
            Intrinsics.checkNotNullExpressionValue(slot, "slot");
            jSONObject.put("slot", w(slot));
        }
        return jSONObject;
    }

    public static final void a(JSONObject jSONObject, String key, int[] array) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(array, "array");
        JSONArray jSONArray = new JSONArray();
        for (int i3 : array) {
            jSONArray.put(i3);
        }
        jSONObject.put(key, jSONArray);
    }

    public static final <T> void b(JSONObject jSONObject, String key, T[] array) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(array, "array");
        JSONArray jSONArray = new JSONArray();
        for (T t16 : array) {
            jSONArray.mo162put(t16);
        }
        jSONObject.put(key, jSONArray);
    }

    public static final i c(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        i iVar = new i();
        iVar.f429601a = jSONObject.optInt("control_index");
        iVar.f429602b = jSONObject.optInt("x_per");
        iVar.f429603c = jSONObject.optInt("y_per");
        iVar.f429604d = jSONObject.optInt("side_x_per");
        iVar.f429605e = jSONObject.optInt("side_y_per");
        return iVar;
    }

    public static final j e(JSONObject jSONObject) {
        j jVar = new j();
        if (jSONObject == null) {
            return jVar;
        }
        jVar.f429606a = jSONObject.optInt("version");
        jVar.f429607b = g(jSONObject.optJSONArray("slot_arr"));
        return jVar;
    }

    public static final k f(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        k kVar = new k();
        kVar.f429609a = jSONObject.optInt(MiniAppReportManager2.KEY_SLOT_ID);
        kVar.f429610b = jSONObject.optInt("item_id");
        kVar.f429611c = jSONObject.optLong("inst_id");
        kVar.f429612d = d(jSONObject.optJSONArray("control_points"));
        return kVar;
    }

    public static final JSONObject h(qu4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        qu4.b avatarInfo = aVar.f429572a;
        if (avatarInfo != null) {
            Intrinsics.checkNotNullExpressionValue(avatarInfo, "avatarInfo");
            jSONObject.put("avatar_info", i(avatarInfo));
        }
        j faceInfo = aVar.f429573b;
        if (faceInfo != null) {
            Intrinsics.checkNotNullExpressionValue(faceInfo, "faceInfo");
            jSONObject.put("face_info", n(faceInfo));
        }
        m makeupInfo = aVar.f429574c;
        if (makeupInfo != null) {
            Intrinsics.checkNotNullExpressionValue(makeupInfo, "makeupInfo");
            jSONObject.put("makeup_info", q(makeupInfo));
        }
        qu4.c colorInfo = aVar.f429575d;
        if (colorInfo != null) {
            Intrinsics.checkNotNullExpressionValue(colorInfo, "colorInfo");
            jSONObject.put("color_info", j(colorInfo));
        }
        jSONObject.put("gender", aVar.f429576e);
        return jSONObject;
    }

    public static final JSONObject i(qu4.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", bVar.f429577a);
        JSONArray jSONArray = new JSONArray();
        q[] slotArr = bVar.f429578b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (q it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(s(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        return jSONObject;
    }

    public static final JSONObject j(qu4.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", cVar.f429580a);
        JSONArray jSONArray = new JSONArray();
        d[] slotArr = cVar.f429581b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (d it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(k(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        return jSONObject;
    }

    public static final JSONObject k(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, dVar.f429583a);
        jSONObject.put("color_type", dVar.f429584b);
        p singleColor = dVar.f429585c;
        if (singleColor != null) {
            Intrinsics.checkNotNullExpressionValue(singleColor, "singleColor");
            jSONObject.put("single_color", r(singleColor));
        }
        l gradientType = dVar.f429586d;
        if (gradientType != null) {
            Intrinsics.checkNotNullExpressionValue(gradientType, "gradientType");
            jSONObject.put("gradient_type", p(gradientType));
        }
        return jSONObject;
    }

    public static final JSONObject l(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("color_config_id", gVar.f429593a);
        jSONObject.put("custom_color", gVar.f429594b);
        JSONArray jSONArray = new JSONArray();
        i[] controlPoints = gVar.f429595c;
        Intrinsics.checkNotNullExpressionValue(controlPoints, "controlPoints");
        for (i it : controlPoints) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(m(it));
        }
        jSONObject.put("control_points", jSONArray);
        jSONObject.put("ugc_id", gVar.f429596d);
        return jSONObject;
    }

    public static final JSONObject m(i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("control_index", iVar.f429601a);
        jSONObject.put("x_per", iVar.f429602b);
        jSONObject.put("y_per", iVar.f429603c);
        jSONObject.put("side_x_per", iVar.f429604d);
        jSONObject.put("side_y_per", iVar.f429605e);
        return jSONObject;
    }

    public static final JSONObject n(j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", jVar.f429606a);
        JSONArray jSONArray = new JSONArray();
        k[] slotArr = jVar.f429607b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (k it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(o(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        return jSONObject;
    }

    public static final JSONObject o(k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, kVar.f429609a);
        jSONObject.put("item_id", kVar.f429610b);
        jSONObject.put("inst_id", kVar.f429611c);
        JSONArray jSONArray = new JSONArray();
        i[] controlPoints = kVar.f429612d;
        Intrinsics.checkNotNullExpressionValue(controlPoints, "controlPoints");
        for (i it : controlPoints) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(m(it));
        }
        jSONObject.put("control_points", jSONArray);
        return jSONObject;
    }

    public static final JSONObject p(l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("color_config_id", lVar.f429614a);
        p fromColor = lVar.f429615b;
        if (fromColor != null) {
            Intrinsics.checkNotNullExpressionValue(fromColor, "fromColor");
            jSONObject.put("from_color", r(fromColor));
        }
        p toColor = lVar.f429616c;
        if (toColor != null) {
            Intrinsics.checkNotNullExpressionValue(toColor, "toColor");
            jSONObject.put("to_color", r(toColor));
        }
        jSONObject.put("from_progress", Float.valueOf(lVar.f429617d));
        jSONObject.put("to_progress", Float.valueOf(lVar.f429618e));
        jSONObject.put("progress", Float.valueOf(lVar.f429619f));
        return jSONObject;
    }

    public static final JSONObject q(m mVar) {
        Intrinsics.checkNotNullParameter(mVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", mVar.f429620a);
        JSONArray jSONArray = new JSONArray();
        q[] slotArr = mVar.f429621b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (q it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(s(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        return jSONObject;
    }

    public static final JSONObject r(p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("color_config_id", pVar.f429636a);
        jSONObject.put("custom_color", pVar.f429637b);
        return jSONObject;
    }

    public static final JSONObject s(q qVar) {
        Intrinsics.checkNotNullParameter(qVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, qVar.f429639a);
        jSONObject.put("item_id", qVar.f429640b);
        jSONObject.put("inst_id", qVar.f429641c);
        g customData = qVar.f429642d;
        if (customData != null) {
            Intrinsics.checkNotNullExpressionValue(customData, "customData");
            jSONObject.put("custom_data", l(customData));
        }
        r itemData = qVar.f429643e;
        if (itemData != null) {
            Intrinsics.checkNotNullExpressionValue(itemData, "itemData");
            jSONObject.put("item_data", t(itemData));
        }
        return jSONObject;
    }

    public static final JSONObject t(r rVar) {
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", rVar.f429644a);
        jSONObject.put("model_full_dose", rVar.f429645b);
        String[] overrideMaterialSlots = rVar.f429646c;
        Intrinsics.checkNotNullExpressionValue(overrideMaterialSlots, "overrideMaterialSlots");
        b(jSONObject, "override_material_slots", overrideMaterialSlots);
        String[] overrideMaterialAssets = rVar.f429647d;
        Intrinsics.checkNotNullExpressionValue(overrideMaterialAssets, "overrideMaterialAssets");
        b(jSONObject, "override_material_assets", overrideMaterialAssets);
        jSONObject.put("animation_bp", rVar.f429648e);
        jSONObject.put("avatar_type", rVar.f429649f);
        jSONObject.put("additional_info", rVar.f429650g);
        jSONObject.put("shoe_height", Float.valueOf(rVar.f429651h));
        jSONObject.put("is_ugc", rVar.f429652i);
        jSONObject.put("color_tex", rVar.f429653j);
        jSONObject.put("normal_tex", rVar.f429654k);
        jSONObject.put("mask_tex", rVar.f429655l);
        int[] offsetScale = rVar.f429656m;
        Intrinsics.checkNotNullExpressionValue(offsetScale, "offsetScale");
        a(jSONObject, "offset_scale", offsetScale);
        jSONObject.put("slot_name", rVar.f429657n);
        int[] containAvatars = rVar.f429658o;
        Intrinsics.checkNotNullExpressionValue(containAvatars, "containAvatars");
        a(jSONObject, "contain_avatars", containAvatars);
        jSONObject.put("anim_group_id", rVar.f429659p);
        String[] relaxHeadNan = rVar.f429660q;
        Intrinsics.checkNotNullExpressionValue(relaxHeadNan, "relaxHeadNan");
        b(jSONObject, "relax_head_nan", relaxHeadNan);
        String[] relaxBodyNan = rVar.f429661r;
        Intrinsics.checkNotNullExpressionValue(relaxBodyNan, "relaxBodyNan");
        b(jSONObject, "relax_body_nan", relaxBodyNan);
        String[] relaxHeadNv = rVar.f429662s;
        Intrinsics.checkNotNullExpressionValue(relaxHeadNv, "relaxHeadNv");
        b(jSONObject, "relax_head_nv", relaxHeadNv);
        String[] relaxBodyNv = rVar.f429663t;
        Intrinsics.checkNotNullExpressionValue(relaxBodyNv, "relaxBodyNv");
        b(jSONObject, "relax_body_nv", relaxBodyNv);
        jSONObject.put("ugc_texture_path", rVar.f429664u);
        jSONObject.put("ugc_texture_cfg_path", rVar.f429665v);
        jSONObject.put("head_montage_path", rVar.f429666w);
        jSONObject.put("body_montage_path", rVar.f429667z);
        jSONObject.put("hide_glove_section", rVar.A);
        jSONObject.put("ext_data", rVar.B);
        jSONObject.put("idle_head_nan", rVar.C);
        jSONObject.put("idle_body_nan", rVar.D);
        jSONObject.put("idle_head_nv", rVar.E);
        jSONObject.put("idle_body_nv", rVar.F);
        return jSONObject;
    }

    public static final JSONObject u(am amVar) {
        JSONObject jSONObject = new JSONObject();
        if (amVar == null) {
            return jSONObject;
        }
        jSONObject.put("id", amVar.f440157a);
        jSONObject.put("group_id", amVar.f440158b);
        jSONObject.put("camera_name", amVar.f440159c);
        jSONObject.put(CanvasView.ACTION_ROTATE, amVar.f440160d);
        jSONObject.put("auto_revert", amVar.f440161e);
        jSONObject.put("shoes_revert", amVar.f440162f);
        jSONObject.put("tag_1", amVar.f440163g);
        jSONObject.put("dynamic_shadow_distance_movable_light_1", amVar.f440164h);
        jSONObject.put("tag_2", amVar.f440165i);
        jSONObject.put("dynamic_shadow_distance_movable_light_2", amVar.f440166j);
        jSONObject.put("anim_type", amVar.f440167k);
        jSONObject.put("blend_time", Float.valueOf(amVar.f440168l));
        jSONObject.put("body_item_id", amVar.f440169m);
        return jSONObject;
    }

    public static final JSONObject v(aw awVar) {
        Intrinsics.checkNotNullParameter(awVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, awVar.f440240a);
        jSONObject.put("gender", awVar.f440241b);
        jSONObject.put("point_index", awVar.f440242c);
        jSONObject.put("control_point", awVar.f440243d);
        jSONObject.put("vertex_name", awVar.f440244e);
        jSONObject.put("x_control_index", awVar.f440245f);
        jSONObject.put("y_control_index", awVar.f440246g);
        jSONObject.put("side_x_control_index", awVar.f440247h);
        jSONObject.put("side_y_control_index", awVar.f440248i);
        jSONObject.put("desc", awVar.f440249j);
        jSONObject.put("side_desc", awVar.f440250k);
        jSONObject.put("side_hide", awVar.f440251l);
        jSONObject.put("hide", awVar.f440252m);
        jSONObject.put("x_offset", awVar.f440253n);
        jSONObject.put("y_offset", awVar.f440254o);
        jSONObject.put("side_x_offset", awVar.f440255p);
        jSONObject.put("side_y_offset", awVar.f440256q);
        return jSONObject;
    }

    public static final JSONObject w(be beVar) {
        Intrinsics.checkNotNullParameter(beVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("slot", beVar.f440324a);
        int[] occupancySlots = beVar.f440325b;
        Intrinsics.checkNotNullExpressionValue(occupancySlots, "occupancySlots");
        a(jSONObject, "occupancy_slots", occupancySlots);
        return jSONObject;
    }

    public static final JSONArray x(List<aw> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(v((aw) it.next()));
        }
        return jSONArray;
    }

    public static final JSONArray y(List<az> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(I((az) it.next()));
        }
        return jSONArray;
    }

    public static final JSONArray z(Map<Integer, az> map) {
        if (map == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<Integer, az> entry : map.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slot", entry.getKey().intValue());
            jSONObject.put(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, I(entry.getValue()));
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    public static final i[] d(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new i[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length <= 0) {
            Object[] array = arrayList.toArray(new i[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (i[]) array;
        }
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (jSONObject != null) {
                arrayList.add(c(jSONObject));
            }
        }
        Object[] array2 = arrayList.toArray(new i[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (i[]) array2;
    }

    public static final k[] g(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new k[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length <= 0) {
            Object[] array = arrayList.toArray(new k[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (k[]) array;
        }
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (jSONObject != null) {
                arrayList.add(f(jSONObject));
            }
        }
        Object[] array2 = arrayList.toArray(new k[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (k[]) array2;
    }
}
