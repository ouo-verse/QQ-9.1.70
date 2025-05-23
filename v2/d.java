package v2;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.health.provider.HealthDataQueryRequest;
import com.health.provider.HealthDataRemoteResponse;
import com.heytap.databaseengine.apiv3.data.Element;
import com.hihonor.mcs.fitness.health.constants.DataType;
import com.hihonor.mcs.fitness.health.datastore.QueryRequest;
import com.hihonor.mcs.fitness.health.internal.exception.IllegalDataException;
import com.hihonor.mcs.fitness.health.internal.exception.IllegalOperationException;
import com.huawei.hms.hihealth.data.Field;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q2.o;
import u2.aa;
import u2.ab;
import u2.ac;
import u2.ad;
import u2.ae;
import u2.af;
import u2.ag;
import u2.ah;
import u2.ai;
import u2.aj;
import u2.ak;
import u2.al;
import u2.am;
import u2.an;
import u2.ao;
import u2.g;
import u2.h;
import u2.i;
import u2.j;
import u2.k;
import u2.l;
import u2.m;
import u2.n;
import u2.p;
import u2.q;
import u2.r;
import u2.s;
import u2.t;
import u2.u;
import u2.v;
import u2.w;
import u2.x;
import u2.y;
import u2.z;
import w1.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static final String f440778d = "DataServiceProxy";

    /* renamed from: e, reason: collision with root package name */
    public static d f440779e;

    /* renamed from: a, reason: collision with root package name */
    public w1.b f440780a;

    /* renamed from: b, reason: collision with root package name */
    public Map<Object, Object> f440781b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public Map<Integer, Integer> f440782c = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends a.AbstractBinderC11451a {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Boolean[] f440783d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f440784e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f440785f;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ s2.c f440786h;

        public a(d dVar, Boolean[] boolArr, CountDownLatch countDownLatch, StringBuilder sb5, s2.c cVar) {
            this.f440783d = boolArr;
            this.f440784e = countDownLatch;
            this.f440785f = sb5;
            this.f440786h = cVar;
        }

        @Override // w1.a
        public void D0(HealthDataRemoteResponse healthDataRemoteResponse) {
            Log.i(d.f440778d, "querySummary success");
            if (healthDataRemoteResponse == null) {
                this.f440783d[0] = Boolean.TRUE;
                this.f440784e.countDown();
                return;
            }
            this.f440785f.append(healthDataRemoteResponse.f36071e);
            if (healthDataRemoteResponse.f36074i.intValue() + 1 >= healthDataRemoteResponse.f36073h.intValue()) {
                this.f440783d[0] = Boolean.TRUE;
                this.f440784e.countDown();
            }
        }

        @Override // w1.a
        public void a(int i3, String str) {
            try {
                Log.e(d.f440778d, "queryData failed, code=" + i3 + ", reason=" + str);
                this.f440783d[0] = Boolean.FALSE;
                this.f440784e.countDown();
                this.f440786h.onFail(i3, str);
            } catch (Exception unused) {
                Log.e(d.f440778d, "queryData unknown exception from client");
            }
        }
    }

    public d(Context context) {
        f();
    }

    public final int a(String str) throws IllegalDataException {
        int i3;
        if (str == null) {
            return 0;
        }
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Log.e(f440778d, "error pageToken " + str);
            i3 = -1;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalDataException(100011, "ILLEGAL_DATA");
    }

    public final void c(int i3, StringBuilder sb5, s2.c cVar, QueryRequest queryRequest) throws RemoteException, InterruptedException, IllegalDataException, JSONException {
        boolean z16;
        boolean z17;
        d dVar = this;
        JSONObject jSONObject = new JSONObject(sb5.toString());
        List arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("detail");
        if (jSONArray != null) {
            arrayList = x2.c.b(i3, jSONArray);
        }
        List list = arrayList;
        p2.b bVar = new p2.b();
        int i16 = 1;
        int a16 = dVar.a(queryRequest.e()) + 1;
        if (queryRequest.d() * a16 < new JSONObject(sb5.toString()).getInt("total")) {
            bVar.g(String.valueOf(a16));
        }
        boolean z18 = false;
        if (DataType.b(i3) == 2 && !list.isEmpty()) {
            int i17 = 0;
            while (i17 < list.size()) {
                p2.b bVar2 = new p2.b();
                bVar2.g(bVar.c());
                bVar2.h(list.size());
                bVar2.f(i17);
                o2.b bVar3 = (o2.b) list.get(i17);
                HealthDataQueryRequest healthDataQueryRequest = new HealthDataQueryRequest();
                healthDataQueryRequest.f36064d = Integer.valueOf(bVar3.a());
                String[] strArr = new String[i16];
                strArr[z18 ? 1 : 0] = bVar3.b();
                healthDataQueryRequest.f36069m = Arrays.asList(strArr);
                healthDataQueryRequest.f36065e = DataType.a(bVar3.a());
                StringBuilder sb6 = new StringBuilder();
                boolean[] zArr = new boolean[i16];
                zArr[z18 ? 1 : 0] = z18;
                CountDownLatch countDownLatch = new CountDownLatch(i16);
                dVar.f440780a.Q2(healthDataQueryRequest, new e(this, zArr, countDownLatch, sb6, bVar2, cVar));
                if (!countDownLatch.await(20L, TimeUnit.SECONDS)) {
                    Log.e(f440778d, "queryDetail timeout");
                    cVar.onFail(12, "TIME_OUT");
                    z17 = false;
                    z16 = false;
                } else {
                    z16 = false;
                    sb6.delete(0, sb6.length());
                    z17 = zArr[0];
                }
                if (!z17) {
                    return;
                }
                i17++;
                dVar = this;
                z18 = z16;
                i16 = 1;
            }
            return;
        }
        bVar.h(1);
        bVar.f(0);
        bVar.e(list);
        cVar.a(list.size(), bVar);
    }

    public void d(QueryRequest queryRequest, s2.c cVar) throws JSONException, IllegalDataException, IllegalOperationException, RemoteException {
        x2.a.c(queryRequest);
        x2.a.c(cVar);
        x2.a.b(queryRequest.a(), "queryData");
        x2.a.a(queryRequest.a(), 8);
        x2.a.c(queryRequest);
        if (queryRequest.f() >= 1388534400000L && queryRequest.b() >= queryRequest.f()) {
            if (x2.d.b(queryRequest.a())) {
                queryRequest.h(x2.e.b(queryRequest.f()));
                queryRequest.g(x2.e.b(queryRequest.b()));
            } else if (x2.d.a(queryRequest.a())) {
                queryRequest.h(x2.e.a(queryRequest.f()));
                queryRequest.g(x2.e.a(queryRequest.b()));
            }
            x2.a.c(queryRequest);
            if (queryRequest.d() >= 1 && queryRequest.d() <= 100) {
                HealthDataQueryRequest healthDataQueryRequest = new HealthDataQueryRequest();
                healthDataQueryRequest.f36064d = Integer.valueOf(queryRequest.a());
                healthDataQueryRequest.f36066f = Long.valueOf(queryRequest.f());
                healthDataQueryRequest.f36067h = Long.valueOf(queryRequest.b());
                healthDataQueryRequest.C = Integer.valueOf(queryRequest.c());
                healthDataQueryRequest.D = Integer.valueOf(a(queryRequest.e()));
                healthDataQueryRequest.E = Integer.valueOf(queryRequest.d());
                StringBuilder sb5 = new StringBuilder();
                CountDownLatch countDownLatch = new CountDownLatch(1);
                w1.b bVar = this.f440780a;
                if (bVar != null) {
                    Boolean[] boolArr = {Boolean.FALSE};
                    bVar.Q2(healthDataQueryRequest, new a(this, boolArr, countDownLatch, sb5, cVar));
                    try {
                        if (!countDownLatch.await(20L, TimeUnit.SECONDS)) {
                            Log.e(f440778d, "query await time out.");
                            cVar.onFail(12, "TIME_OUT");
                            return;
                        } else {
                            if (boolArr[0].booleanValue()) {
                                c(queryRequest.a(), sb5, cVar, queryRequest);
                                return;
                            }
                            return;
                        }
                    } catch (InterruptedException unused) {
                        Log.e(f440778d, "await exception.");
                        cVar.onFail(12, "TIME_OUT");
                        return;
                    }
                }
                return;
            }
            throw new IllegalDataException(100011, "ILLEGAL_DATA");
        }
        throw new IllegalDataException(100003, "ILLEGAL_TIME");
    }

    public void e(w1.b bVar) {
        this.f440780a = bVar;
        if (bVar == null) {
            Log.w(f440778d, "null health data service");
        }
    }

    public final void f() {
        int i3 = u2.a.f438061b;
        HashMap hashMap = new HashMap();
        hashMap.put("height", new x2.b("Float", 0));
        Map<Integer, Map<String, x2.b>> map = o.f428221a;
        map.put(8, hashMap);
        int i16 = u2.c.f438076b;
        HashMap hashMap2 = new HashMap();
        x2.b bVar = new x2.b("Integer", 0);
        bVar.f447070c = 1;
        long j3 = 100;
        bVar.f447071d = j3;
        hashMap2.put("bloodOxygen", bVar);
        map.put(16, hashMap2);
        int i17 = u2.d.f438077b;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("avgValue", new x2.b("Integer", 0));
        hashMap3.put("maxValue", new x2.b("Integer", 0));
        hashMap3.put("minValue", new x2.b("Integer", 0));
        map.put(210, hashMap3);
        int i18 = u2.f.f438079b;
        HashMap hashMap4 = new HashMap();
        hashMap4.put("averageHighPressure", new x2.b("Integer", 0));
        hashMap4.put("maxHighPressure", new x2.b("Integer", 0));
        hashMap4.put("minHighPressure", new x2.b("Integer", 0));
        hashMap4.put("averageLowPressure", new x2.b("Integer", 0));
        hashMap4.put("maxLowPressure", new x2.b("Integer", 0));
        hashMap4.put("minLowPressure", new x2.b("Integer", 0));
        hashMap4.put("averagePulse", new x2.b("Integer", 0));
        hashMap4.put("maxPulse", new x2.b("Integer", 0));
        hashMap4.put("minPulse", new x2.b("Integer", 0));
        map.put(209, hashMap4);
        int i19 = u2.e.f438078b;
        HashMap hashMap5 = new HashMap();
        x2.b bVar2 = new x2.b("Integer", 0);
        bVar2.f447070c = 40;
        bVar2.f447071d = 300;
        hashMap5.put("highPressure", bVar2);
        x2.b bVar3 = new x2.b("Integer", 0);
        bVar3.f447070c = 30;
        bVar3.f447071d = 200;
        hashMap5.put("lowPressure", bVar3);
        x2.b bVar4 = new x2.b("Integer", 1);
        bVar4.f447072e = new int[]{0, 1, 2, 3, 4, 5};
        hashMap5.put("pressureType", bVar4);
        x2.b bVar5 = new x2.b("Integer", 0);
        bVar5.f447070c = 30;
        long j16 = 180;
        bVar5.f447071d = j16;
        hashMap5.put("pulse", bVar5);
        map.put(15, hashMap5);
        int i26 = g.f438080b;
        HashMap hashMap6 = new HashMap();
        x2.b bVar6 = new x2.b("Float", 0);
        bVar6.f447070c = 1;
        long j17 = 33;
        bVar6.f447071d = j17;
        hashMap6.put("measureValue", bVar6);
        x2.b bVar7 = new x2.b("Integer", 1);
        bVar7.f447072e = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        hashMap6.put("timeRange", bVar7);
        map.put(14, hashMap6);
        int i27 = h.f438081b;
        HashMap hashMap7 = new HashMap();
        x2.b bVar8 = new x2.b("Float", 0);
        bVar8.f447070c = 34;
        bVar8.f447071d = 42;
        hashMap7.put("temperature", bVar8);
        x2.b bVar9 = new x2.b("Integer", 1);
        bVar9.f447072e = new int[]{0, 1, 2, 3, 4};
        hashMap7.put("measureType", bVar9);
        x2.b bVar10 = new x2.b("Integer", 1);
        bVar10.f447072e = new int[]{1, 2};
        hashMap7.put("temperatureType", bVar10);
        map.put(17, hashMap7);
        int i28 = i.f438082b;
        HashMap hashMap8 = new HashMap();
        hashMap8.put("avgValue", new x2.b("Float", 0));
        hashMap8.put("maxValue", new x2.b("Float", 0));
        hashMap8.put("minValue", new x2.b("Float", 0));
        map.put(211, hashMap8);
        int i29 = j.f438083b;
        HashMap hashMap9 = new HashMap();
        x2.b bVar11 = new x2.b("Integer", 0);
        bVar11.f447070c = 1;
        bVar11.f447071d = j17;
        hashMap9.put(Field.NUTRIENTS_FACTS_CALORIES, bVar11);
        map.put(9, hashMap9);
        int i36 = l.f438085b;
        HashMap hashMap10 = new HashMap();
        x2.b bVar12 = new x2.b("Integer", 0);
        bVar12.f447070c = 1;
        bVar12.f447071d = 6000;
        hashMap10.put(Element.ELEMENT_NAME_DISTANCE, bVar12);
        map.put(7, hashMap10);
        int i37 = u2.o.f438087b;
        HashMap hashMap11 = new HashMap();
        x2.b bVar13 = new x2.b("Integer", 0);
        bVar13.f447070c = 31;
        long j18 = 254;
        bVar13.f447071d = j18;
        hashMap11.put("maxHeartRate", bVar13);
        x2.b bVar14 = new x2.b("Integer", 0);
        bVar14.f447070c = 31;
        bVar14.f447071d = j18;
        hashMap11.put("minHeartRate", bVar14);
        x2.b bVar15 = new x2.b("Integer", 0);
        bVar15.f447070c = 31;
        bVar15.f447071d = j18;
        hashMap11.put("warningLimit", bVar15);
        x2.b bVar16 = new x2.b("Integer", 1);
        bVar16.f447072e = new int[]{0, 1};
        hashMap11.put("warningType", bVar16);
        map.put(19, hashMap11);
        int i38 = p.f438088b;
        HashMap hashMap12 = new HashMap();
        x2.b bVar17 = new x2.b("Integer", 0);
        bVar17.f447070c = 31;
        bVar17.f447071d = j18;
        hashMap12.put("dynamicHeartRate", bVar17);
        x2.b bVar18 = new x2.b("Integer", 0);
        bVar18.f447070c = 31;
        bVar18.f447071d = j18;
        hashMap12.put("restingHeartRate", bVar18);
        map.put(4, hashMap12);
        int i39 = q.f438089b;
        HashMap hashMap13 = new HashMap();
        hashMap13.put("maxValue", new x2.b("Integer", 0));
        hashMap13.put("minValue", new x2.b("Integer", 0));
        hashMap13.put("averageValue", new x2.b("Integer", 0));
        hashMap13.put("maxRestingValue", new x2.b("Integer", 0));
        hashMap13.put("minRestingValue", new x2.b("Integer", 0));
        hashMap13.put("restingAveValue", new x2.b("Integer", 0));
        map.put(202, hashMap13);
        int i46 = r.f438090b;
        HashMap hashMap14 = new HashMap();
        hashMap14.put("sportTime", new x2.b("Integer", 0));
        hashMap14.put(Element.ELEMENT_NAME_CALORIE, new x2.b("Float", 0));
        hashMap14.put("speed", new x2.b("Integer", 0));
        hashMap14.put("tripped", new x2.b("Integer", 0));
        hashMap14.put("longestStreak", new x2.b("Integer", 0));
        x2.b bVar19 = new x2.b("Integer", 0);
        bVar19.f447070c = 31;
        bVar19.f447071d = j18;
        hashMap14.put("avgHeartRate", bVar19);
        map.put(Integer.valueOf(PlayerResources.ViewId.PLAYER_DURATION), hashMap14);
        int i47 = s.f438091b;
        HashMap hashMap15 = new HashMap();
        hashMap15.put("speed", new x2.b("Integer", 0));
        map.put(503, hashMap15);
        int i48 = t.f438092b;
        HashMap hashMap16 = new HashMap();
        x2.b bVar20 = new x2.b("Double", 0);
        bVar20.f447070c = -90;
        bVar20.f447071d = 90;
        hashMap16.put("latitude", bVar20);
        x2.b bVar21 = new x2.b("Double", 0);
        bVar21.f447070c = -180;
        bVar21.f447071d = j16;
        hashMap16.put("longitude", bVar21);
        hashMap16.put("precision", new x2.b("Float", 0));
        hashMap16.put("speed", new x2.b("Float", 0));
        x2.b bVar22 = new x2.b("Integer", 1);
        bVar22.f447072e = new int[]{0, 1};
        hashMap16.put("gpsTra", bVar22);
        map.put(13, hashMap16);
        int i49 = u.f438093b;
        HashMap hashMap17 = new HashMap();
        hashMap17.put("maxVO2", new x2.b("Integer", 0));
        x2.b bVar23 = new x2.b("Integer", 1);
        bVar23.f447072e = new int[]{1, 2, 3, 4, 5, 6, 7};
        hashMap17.put("maxVO2Level", bVar23);
        x2.b bVar24 = new x2.b("Integer", 1);
        bVar24.f447072e = new int[]{1, 2, 3, 5, 21};
        hashMap17.put("sportType", bVar24);
        map.put(10, hashMap17);
        int i56 = v.f438094b;
        HashMap hashMap18 = new HashMap();
        x2.b bVar25 = new x2.b("Integer", 1);
        bVar25.f447072e = new int[]{0, 1, 2, 3, 4};
        hashMap18.put("status", bVar25);
        x2.b bVar26 = new x2.b("Integer", 1);
        bVar26.f447072e = new int[]{0, 1, 2};
        hashMap18.put("subStatus", bVar26);
        x2.b bVar27 = new x2.b("Integer", 1);
        bVar27.f447072e = new int[]{1, 2, 3};
        hashMap18.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, bVar27);
        x2.b bVar28 = new x2.b("Integer", 1);
        bVar28.f447072e = new int[]{1, 2, 3};
        hashMap18.put("level", bVar28);
        map.put(18, hashMap18);
        int i57 = w.f438095b;
        HashMap hashMap19 = new HashMap();
        x2.b bVar29 = new x2.b("Integer", 1);
        bVar29.f447072e = new int[]{6, 7, 8, 1001};
        hashMap19.put("status", bVar29);
        hashMap19.put("duration", new x2.b("Integer", 0));
        map.put(10002, hashMap19);
        int i58 = x.f438096b;
        HashMap hashMap20 = new HashMap();
        x2.b bVar30 = new x2.b("Integer", 1);
        bVar30.f447072e = new int[]{6, 7, 8, 1001};
        hashMap20.put("status", bVar30);
        hashMap20.put("duration", new x2.b("Integer", 0));
        map.put(10001, hashMap20);
        int i59 = ac.f438064b;
        HashMap hashMap21 = new HashMap();
        hashMap21.put(Element.ELEMENT_NAME_DISTANCE, new x2.b("Integer", 0));
        hashMap21.put("sportTime", new x2.b("Integer", 0));
        hashMap21.put(Element.ELEMENT_NAME_CALORIE, new x2.b("Float", 0));
        hashMap21.put("speed", new x2.b("Float", 0));
        x2.b bVar31 = new x2.b("Integer", 0);
        bVar31.f447070c = 31;
        bVar31.f447071d = j18;
        hashMap21.put("avgHeartRate", bVar31);
        map.put(Integer.valueOf(PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON), hashMap21);
        int i65 = ad.f438065b;
        HashMap hashMap22 = new HashMap();
        hashMap22.put(Element.ELEMENT_NAME_DISTANCE, new x2.b("Integer", 0));
        hashMap22.put("sportTime", new x2.b("Integer", 0));
        hashMap22.put(Element.ELEMENT_NAME_CALORIE, new x2.b("Float", 0));
        hashMap22.put("speed", new x2.b("Float", 0));
        hashMap22.put("steps", new x2.b("Integer", 0));
        hashMap22.put(StepCounterConstants.ATTR_STEP_CADENCE, new x2.b("Integer", 0));
        x2.b bVar32 = new x2.b("Integer", 0);
        bVar32.f447070c = 31;
        bVar32.f447071d = j18;
        hashMap22.put("avgHeartRate", bVar32);
        map.put(552, hashMap22);
        int i66 = ae.f438066b;
        HashMap hashMap23 = new HashMap();
        hashMap23.put(Element.ELEMENT_NAME_DISTANCE, new x2.b("Integer", 0));
        hashMap23.put("sportTime", new x2.b("Integer", 0));
        hashMap23.put(Element.ELEMENT_NAME_CALORIE, new x2.b("Float", 0));
        hashMap23.put("speed", new x2.b("Float", 0));
        hashMap23.put("steps", new x2.b("Integer", 0));
        hashMap23.put(StepCounterConstants.ATTR_STEP_CADENCE, new x2.b("Integer", 0));
        x2.b bVar33 = new x2.b("Integer", 0);
        bVar33.f447070c = 31;
        bVar33.f447071d = j18;
        hashMap23.put("avgHeartRate", bVar33);
        hashMap23.put("totalRiseHeight", new x2.b("Float", 0));
        hashMap23.put("totalDropHeight", new x2.b("Float", 0));
        map.put(Integer.valueOf(PlayerResources.ViewId.TITLE_BAR), hashMap23);
        int i67 = af.f438067b;
        HashMap hashMap24 = new HashMap();
        hashMap24.put("deepSleep", new x2.b("Integer", 0));
        hashMap24.put("lightSleep", new x2.b("Integer", 0));
        hashMap24.put("remSleep", new x2.b("Integer", 0));
        hashMap24.put("wideAwake", new x2.b("Integer", 0));
        hashMap24.put("awakeTimes", new x2.b("Integer", 0));
        x2.b bVar34 = new x2.b("Integer", 1);
        bVar34.f447072e = new int[]{0, 1};
        hashMap24.put("sleepType", bVar34);
        hashMap24.put("sporadicNaps", new x2.b("Integer", 0));
        x2.b bVar35 = new x2.b("Integer", 0);
        bVar35.f447070c = 0;
        bVar35.f447071d = j3;
        hashMap24.put("sleepQuality", bVar35);
        x2.b bVar36 = new x2.b("Integer", 0);
        bVar36.f447070c = 0;
        bVar36.f447071d = j3;
        hashMap24.put("respiratoryQuality", bVar36);
        x2.b bVar37 = new x2.b("Integer", 0);
        bVar37.f447070c = 0;
        bVar37.f447071d = j3;
        hashMap24.put("deepSleepContinue", bVar37);
        hashMap24.put("sleepTimestamp", new x2.b("Long", 0));
        hashMap24.put("wakeupTimestamp", new x2.b("Long", 0));
        map.put(3, hashMap24);
        int i68 = ag.f438068b;
        HashMap hashMap25 = new HashMap();
        hashMap25.put("speed", new x2.b("Float", 0));
        map.put(502, hashMap25);
        int i69 = ah.f438069b;
        HashMap hashMap26 = new HashMap();
        x2.b bVar38 = new x2.b("Integer", 0);
        bVar38.f447070c = 1;
        bVar38.f447071d = 500;
        hashMap26.put("step", bVar38);
        map.put(6, hashMap26);
        int i75 = ai.f438070b;
        HashMap hashMap27 = new HashMap();
        hashMap27.put("stepRate", new x2.b("Integer", 0));
        map.put(501, hashMap27);
        int i76 = ak.f438071b;
        HashMap hashMap28 = new HashMap();
        x2.b bVar39 = new x2.b("Integer", 1);
        bVar39.f447072e = new int[]{1, 2, 3, 4, 9};
        hashMap28.put("motionType", bVar39);
        map.put(11, hashMap28);
        int i77 = al.f438072b;
        HashMap hashMap29 = new HashMap();
        hashMap29.put("walkDuration", new x2.b("Integer", 0));
        hashMap29.put("runDuration", new x2.b("Integer", 0));
        hashMap29.put("climbDuration", new x2.b("Integer", 0));
        hashMap29.put("rideDuration", new x2.b("Integer", 0));
        hashMap29.put("swimDuration", new x2.b("Integer", 0));
        map.put(208, hashMap29);
        int i78 = am.f438073b;
        HashMap hashMap30 = new HashMap();
        x2.b bVar40 = new x2.b("Integer", 0);
        bVar40.f447070c = 1;
        bVar40.f447071d = 99;
        hashMap30.put(LocalPhotoFaceInfo.SCORE, bVar40);
        x2.b bVar41 = new x2.b("Integer", 1);
        bVar41.f447072e = new int[]{1, 2, 3, 4};
        hashMap30.put("grade", bVar41);
        x2.b bVar42 = new x2.b("Integer", 1);
        bVar42.f447072e = new int[]{0, 1};
        hashMap30.put("measureType", bVar42);
        map.put(5, hashMap30);
        int i79 = an.f438074b;
        HashMap hashMap31 = new HashMap();
        hashMap31.put("maxScore", new x2.b("Integer", 0));
        hashMap31.put("minScore", new x2.b("Integer", 0));
        hashMap31.put("avgScore", new x2.b("Integer", 0));
        map.put(203, hashMap31);
        int i85 = ao.f438075b;
        HashMap hashMap32 = new HashMap();
        hashMap32.put(Element.ELEMENT_NAME_DISTANCE, new x2.b("Integer", 0));
        hashMap32.put("sportTime", new x2.b("Integer", 0));
        hashMap32.put(Element.ELEMENT_NAME_CALORIE, new x2.b("Float", 0));
        hashMap32.put("speed", new x2.b("Float", 0));
        hashMap32.put("steps", new x2.b("Integer", 0));
        hashMap32.put(StepCounterConstants.ATTR_STEP_CADENCE, new x2.b("Integer", 0));
        x2.b bVar43 = new x2.b("Integer", 0);
        bVar43.f447070c = 31;
        bVar43.f447071d = j18;
        hashMap32.put("avgHeartRate", bVar43);
        hashMap32.put("totalRiseHeight", new x2.b("Float", 0));
        hashMap32.put("totalDropHeight", new x2.b("Float", 0));
        map.put(Integer.valueOf(PlayerResources.ViewId.LOADING), hashMap32);
        int i86 = z.f438097b;
        HashMap hashMap33 = new HashMap();
        hashMap33.put("heartRate", new x2.b("Integer", 0));
        hashMap33.put("steps", new x2.b("Integer", 0));
        map.put(23, hashMap33);
        int i87 = ab.f438063b;
        HashMap hashMap34 = new HashMap();
        hashMap34.put("steps", new x2.b("Integer", 0));
        map.put(26, hashMap34);
        int i88 = aa.f438062b;
        HashMap hashMap35 = new HashMap();
        hashMap35.put("heartRate", new x2.b("Integer", 0));
        map.put(21, hashMap35);
        int i89 = k.f438084b;
        HashMap hashMap36 = new HashMap();
        hashMap36.put("calorieRun", new x2.b("Integer", 0));
        hashMap36.put("calorieWalk", new x2.b("Integer", 0));
        hashMap36.put("calorieRide", new x2.b("Integer", 0));
        hashMap36.put("calorieExcise", new x2.b("Integer", 0));
        hashMap36.put("calorieOther", new x2.b("Integer", 0));
        map.put(207, hashMap36);
        int i95 = m.f438086b;
        HashMap hashMap37 = new HashMap();
        hashMap37.put("distanceRun", new x2.b("Integer", 0));
        hashMap37.put("distanceWalk", new x2.b("Integer", 0));
        hashMap37.put("distanceClimb", new x2.b("Integer", 0));
        hashMap37.put("distanceOther", new x2.b("Integer", 0));
        map.put(205, hashMap37);
        aj.b();
        u2.b.b();
        n.b();
        y.b();
    }
}
