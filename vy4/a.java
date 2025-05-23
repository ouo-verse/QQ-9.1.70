package vy4;

import android.app.Activity;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.DeadObjectException;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.vivo.datashare.permission.PermissionRequest;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a implements com.vivo.datashare.permission.b<PermissionRequest> {
    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str.trim())) {
            return str.trim();
        }
        if ("null".equals(str.trim())) {
            return null;
        }
        return str;
    }

    private String c(PermissionRequest permissionRequest) {
        if (permissionRequest == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(permissionRequest.toString());
            String b16 = b(jSONObject.getString("token"));
            String b17 = b(jSONObject.getString("appId"));
            long j3 = jSONObject.getLong("requestTime");
            String b18 = b(jSONObject.getString("requestTips"));
            String b19 = b(jSONObject.getString("permissionName"));
            int i3 = jSONObject.getInt("permissionGroup");
            String b26 = b(jSONObject.getString("appDisplayName"));
            String b27 = b(jSONObject.getString("appIconUrl"));
            int i16 = jSONObject.getInt("appType");
            jSONObject.put("token", b16);
            jSONObject.put("appId", b17);
            jSONObject.put("requestTime", j3);
            jSONObject.put("requestTips", b18);
            jSONObject.put("permissionName", b19);
            jSONObject.put("permissionGroup", i3);
            jSONObject.put("appDisplayName", b26);
            jSONObject.put("appIconUrl", b27);
            jSONObject.put("appType", i16);
            return jSONObject.toString();
        } catch (JSONException e16) {
            Log.e("SportPermission", "queryDaysStepsBeanToJson JSONException : " + e16);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(Context context, String str, String str2) {
        ContentProviderClient contentProviderClient;
        Log.d("SportPermission", "checkPermission=app_id = ? and permission_key = ?");
        Cursor cursor = null;
        try {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri = c.f443762d;
                contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                if (contentProviderClient == null) {
                    if (contentProviderClient != null) {
                        try {
                            contentProviderClient.release();
                        } catch (Exception unused) {
                        }
                    }
                    return 0;
                }
                try {
                    cursor = contentProviderClient.query(uri, null, "app_id = ? and permission_key = ?", new String[]{str2, str}, null);
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        int i3 = cursor.getInt(cursor.getColumnIndex("permission_status"));
                        cursor.close();
                        try {
                            contentProviderClient.release();
                        } catch (Exception unused2) {
                        }
                        return i3;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    try {
                        contentProviderClient.release();
                    } catch (Exception unused3) {
                    }
                    return 0;
                } catch (DeadObjectException e16) {
                    e = e16;
                    e.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (contentProviderClient != null) {
                        try {
                            contentProviderClient.release();
                        } catch (Exception unused4) {
                        }
                    }
                    return 0;
                } catch (Exception e17) {
                    e = e17;
                    e.printStackTrace();
                    Log.e("SportPermission", "checkPermission");
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (contentProviderClient != null) {
                        try {
                            contentProviderClient.release();
                        } catch (Exception unused5) {
                        }
                    }
                    return 0;
                }
            } catch (DeadObjectException e18) {
                e = e18;
                contentProviderClient = null;
            } catch (Exception e19) {
                e = e19;
                contentProviderClient = null;
            } catch (Throwable th5) {
                th = th5;
                context = 0;
                if (0 != 0) {
                }
                if (context != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            if (0 != 0) {
                cursor.close();
            }
            if (context != 0) {
                try {
                    context.release();
                } catch (Exception unused6) {
                }
            }
            throw th;
        }
    }

    public void d(Context context, PermissionRequest permissionRequest) {
        try {
            String c16 = c(permissionRequest);
            if (TextUtils.isEmpty(c16)) {
                return;
            }
            if (wy4.a.a()) {
                Log.d("SportPermission", "json=" + c16);
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(c16);
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setClassName("com.vivo.assistant", "com.vivo.assistant.securitypermiss.AbsSecurityPermissionsCompatActivity");
            intent.putStringArrayListExtra("permission_request", arrayList);
            if (context != null) {
                if (context instanceof Activity) {
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        ((Activity) context).startActivityForResult(intent, 1);
                    }
                } else {
                    intent.setFlags(268435456);
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent);
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
