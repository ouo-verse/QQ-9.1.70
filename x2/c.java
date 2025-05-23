package x2;

import com.hihonor.mcs.fitness.health.constants.DataType;
import com.hihonor.mcs.fitness.health.internal.exception.IllegalDataTypeException;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o2.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q2.o;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {
    public static List<? extends o2.b> a(int i3, String str) throws JSONException, IllegalDataTypeException {
        JSONObject jSONObject = new JSONObject(str);
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("detail");
        if (jSONArray != null) {
            return b(i3, jSONArray);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0156 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<? extends o2.b> b(int i3, JSONArray jSONArray) throws JSONException, IllegalDataTypeException {
        JSONObject jSONObject;
        String string;
        int i16;
        JSONArray jSONArray2;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i17 = 0; i17 < jSONArray.length(); i17++) {
                JSONArray jSONArray3 = null;
                if (jSONArray.getJSONObject(i17).isNull("bean")) {
                    jSONObject = jSONArray.getJSONObject(i17);
                } else {
                    jSONObject = jSONArray.getJSONObject(i17).getJSONObject("bean");
                    if (!jSONArray.getJSONObject(i17).isNull("id")) {
                        string = jSONArray.getJSONObject(i17).getString("id");
                        if (jSONObject != null) {
                            if (DataType.b(i3) == 2) {
                                o2.e eVar = new o2.e();
                                d(i3, jSONObject, eVar, string);
                                if (!jSONObject.isNull("sportType")) {
                                    int i18 = jSONObject.getInt("sportType");
                                    if (i18 != 2) {
                                        if (i18 != 3) {
                                            if (i18 != 5) {
                                                if (i18 != 21) {
                                                    i16 = PlayerResources.ViewId.TITLE_BAR;
                                                } else {
                                                    i16 = PlayerResources.ViewId.PLAYER_DURATION;
                                                }
                                            } else {
                                                i16 = 552;
                                            }
                                        } else {
                                            i16 = PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON;
                                        }
                                    } else {
                                        i16 = PlayerResources.ViewId.LOADING;
                                    }
                                } else {
                                    i16 = i3;
                                }
                                eVar.d(i16);
                                f fVar = new f();
                                fVar.a(c(i16, jSONObject));
                                eVar.j(fVar);
                                if (i16 == 3) {
                                    if (!jSONObject.isNull("nightSegment")) {
                                        eVar.i().put(10001, b(10001, jSONObject.getJSONArray("nightSegment")));
                                    }
                                    if (!jSONObject.isNull("napSegment")) {
                                        eVar.i().put(10002, b(10002, jSONObject.getJSONArray("napSegment")));
                                    }
                                } else {
                                    if (!jSONObject.isNull("paceInfo")) {
                                        eVar.i().put(10003, b(10003, jSONObject.getJSONArray("paceInfo")));
                                    }
                                    if (!jSONObject.isNull("detailInfo")) {
                                        jSONArray3 = new JSONArray(jSONObject.getString("detailInfo"));
                                    }
                                    if (jSONArray3 != null) {
                                        for (int i19 = 0; i19 < jSONArray3.length(); i19++) {
                                            int i26 = jSONArray3.getJSONObject(i19).getInt("dataType");
                                            if (!jSONArray3.getJSONObject(i19).isNull("value") && (jSONArray2 = jSONArray3.getJSONObject(i19).getJSONArray("value")) != null) {
                                                eVar.i().put(Integer.valueOf(i26), b(i26, jSONArray2));
                                            }
                                        }
                                    }
                                }
                                arrayList.add(eVar);
                            } else if (DataType.b(i3) == 1) {
                                o2.d dVar = new o2.d();
                                d(i3, jSONObject, dVar, string);
                                dVar.j(c(i3, jSONObject));
                                arrayList.add(dVar);
                            }
                        }
                    }
                }
                string = null;
                if (jSONObject != null) {
                }
            }
        }
        return arrayList;
    }

    public static Map<String, o2.a> c(int i3, JSONObject jSONObject) throws IllegalDataTypeException, JSONException {
        if (o.a(i3) != null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, b> entry : o.a(i3).entrySet()) {
                String key = entry.getKey();
                if (!jSONObject.isNull(key) && entry.getValue() != null) {
                    o2.a aVar = new o2.a();
                    if ("Integer".equals(entry.getValue().f447068a)) {
                        aVar.d(jSONObject.getInt(key));
                    } else if ("Long".equals(entry.getValue().f447068a)) {
                        aVar.e(jSONObject.getLong(key));
                    } else if ("Float".equals(entry.getValue().f447068a)) {
                        aVar.c((float) jSONObject.getDouble(key));
                    } else if ("Double".equals(entry.getValue().f447068a)) {
                        aVar.b(jSONObject.getDouble(key));
                    }
                    hashMap.put(key, aVar);
                }
            }
            if (i3 == 208 && !jSONObject.isNull("strengthStatisticData")) {
                JSONArray jSONArray = jSONObject.getJSONArray("strengthStatisticData");
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    if (!jSONArray.getJSONObject(i16).isNull("key") && !jSONArray.getJSONObject(i16).isNull("value")) {
                        o2.a aVar2 = new o2.a();
                        aVar2.d(jSONArray.getJSONObject(i16).getInt("value"));
                        int i17 = jSONArray.getJSONObject(i16).getInt("key");
                        if (i17 != 9) {
                            if (i17 != 1) {
                                if (i17 != 2) {
                                    if (i17 != 3) {
                                        if (i17 == 4) {
                                            hashMap.put("rideDuration", aVar2);
                                        }
                                    } else {
                                        hashMap.put("climbDuration", aVar2);
                                    }
                                } else {
                                    hashMap.put("runDuration", aVar2);
                                }
                            } else {
                                hashMap.put("walkDuration", aVar2);
                            }
                        } else {
                            hashMap.put("swimDuration", aVar2);
                        }
                    }
                }
            }
            return hashMap;
        }
        throw new IllegalDataTypeException("ILLEGAL_DATA_TYPE:{dataType:" + i3 + "}");
    }

    public static void d(int i3, JSONObject jSONObject, o2.b bVar, String str) throws JSONException {
        long j3;
        bVar.d(i3);
        long j16 = 0;
        if (!jSONObject.isNull("endTime")) {
            j3 = jSONObject.getLong("endTime");
        } else if (!jSONObject.isNull("timestamp")) {
            j3 = jSONObject.getLong("timestamp");
        } else if (!jSONObject.isNull("measureTime")) {
            j3 = jSONObject.getLong("measureTime");
        } else {
            j3 = 0;
        }
        if (i3 == 5 || i3 == 7 || i3 == 8 || i3 == 9) {
            j3 += 60000;
        }
        bVar.f(j3);
        if (!jSONObject.isNull("startTime")) {
            j16 = jSONObject.getLong("startTime");
        } else if (!jSONObject.isNull("timestamp")) {
            j16 = jSONObject.getLong("timestamp");
        } else if (!jSONObject.isNull("measureTime")) {
            j16 = jSONObject.getLong("measureTime");
        }
        bVar.h(j16);
        if (!jSONObject.isNull(Constants.SP_DEVICE_ID)) {
            bVar.e(jSONObject.getString(Constants.SP_DEVICE_ID));
        }
        if (!jSONObject.isNull("packageName")) {
            bVar.c(jSONObject.getString("packageName"));
        }
        bVar.g(str);
    }
}
