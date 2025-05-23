package wx;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends Observable implements Manager {
    public static boolean I = false;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f446625d;

    /* renamed from: e, reason: collision with root package name */
    SharedPreferences f446626e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f446627f;

    /* renamed from: h, reason: collision with root package name */
    public int f446628h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f446629i = -100;

    /* renamed from: m, reason: collision with root package name */
    public String f446630m = "";
    public boolean C = true;
    public char D = '0';
    private String E = null;
    protected e.a F = new C11517a();
    Map<String, Long> G = new HashMap();
    HashMap<String, b> H = new HashMap<>();

    /* compiled from: P */
    /* renamed from: wx.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C11517a implements e.a {
        C11517a() {
        }

        @Override // com.tencent.mobileqq.troop.utils.e.a
        public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
            String str;
            String str2;
            JSONObject optJSONObject;
            a.this.setChanged();
            long j3 = 0;
            if (bundle != null) {
                j3 = bundle.getLong("time", 0L);
                str = bundle.getString(AudienceReportConst.ROOM_ID);
                str2 = bundle.getString("friendUin");
            } else {
                str = "";
                str2 = "";
            }
            b d16 = a.this.d(str2, j3);
            if (jSONObject == null) {
                a.this.setChanged();
                a.this.notifyObservers(new Object[]{Integer.valueOf(i3), Boolean.FALSE, d16, bundle});
                return;
            }
            if (i3 != 1001) {
                if (i3 == 1003 && jSONObject.optInt("retcode") == 0 && (optJSONObject = jSONObject.optJSONObject("result")) != null) {
                    d16.f446635d = optJSONObject.optInt("state");
                    a.this.notifyObservers(new Object[]{Integer.valueOf(i3), Boolean.TRUE, d16, bundle});
                    return;
                }
            } else {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
                if (optJSONObject2 != null && optJSONObject2.optInt("retcode") == 0) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject2.optJSONArray("videoURLList");
                    if (optJSONArray != null) {
                        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                            try {
                                arrayList.add(optJSONArray.getString(i16));
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                            }
                        }
                        d16.f446636e = arrayList;
                        d16.f446634c = str;
                    }
                    a.this.notifyObservers(new Object[]{Integer.valueOf(i3), Boolean.TRUE, d16, bundle});
                }
            }
            a.this.notifyObservers(new Object[]{Integer.valueOf(i3), Boolean.FALSE, null, bundle});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        String f446632a;

        /* renamed from: b, reason: collision with root package name */
        long f446633b;

        /* renamed from: c, reason: collision with root package name */
        String f446634c;

        /* renamed from: d, reason: collision with root package name */
        int f446635d = -1;

        /* renamed from: e, reason: collision with root package name */
        List<String> f446636e = new ArrayList();

        b() {
        }

        public String a() {
            return this.f446632a + this.f446633b;
        }
    }

    public a(QQAppInterface qQAppInterface) {
        this.f446626e = null;
        this.f446625d = qQAppInterface;
        this.f446626e = qQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + qQAppInterface.getCurrentAccountUin(), 0);
        f();
    }

    public boolean c() {
        boolean z16;
        if (!com.tencent.biz.qqstory.base.b.c()) {
            return false;
        }
        char charAt = e().charAt(2);
        if (I && this.f446627f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (charAt == '0' || z16) {
            return false;
        }
        return true;
    }

    public b d(String str, long j3) {
        b bVar = this.H.get(str + j3);
        if (bVar == null) {
            b bVar2 = new b();
            bVar2.f446632a = str;
            bVar2.f446633b = j3;
            this.H.put(bVar2.a(), bVar2);
            return bVar2;
        }
        return bVar;
    }

    public String e() {
        if (this.E == null) {
            this.E = this.f446625d.getApp().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + this.f446625d.getCurrentAccountUin(), "00100");
        }
        return this.E;
    }

    public void f() {
        int i3;
        int i16;
        boolean z16 = false;
        this.C = this.f446625d.getApp().getSharedPreferences("now_tab_sp", 0).getBoolean("now_is_first_run_key", true);
        this.f446629i = this.f446625d.getApp().getSharedPreferences("now_tab_sp", 0).getInt("now_index_key", 3);
        this.f446630m = this.f446625d.getApp().getSharedPreferences("now_tab_sp", 0).getString("now_name_key", "");
        if (this.f446628h != -1) {
            return;
        }
        String e16 = e();
        if (e16 != null) {
            this.D = e16.charAt(2);
        }
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.TAG_STORY_FOUR_TAB, 4, "initNowTabShowValue : " + e16);
        }
        if (e16 != null && e16.length() <= 5) {
            if (e16.length() < 5) {
                e16 = e16 + "00100".substring(e16.length());
            }
            char[] charArray = e16.toCharArray();
            char c16 = charArray[2];
            if (charArray[0] == '1') {
                if (charArray[3] != '0' && c16 != '0' && c16 != '1') {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                this.f446628h = i16;
            } else {
                if (charArray[1] != '0' && c16 != '0' && c16 != '1') {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                this.f446628h = i3;
            }
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_STORY_FOUR_TAB, 2, "uin:" + this.f446625d.getCurrentAccountUin() + ",isNowTabShow mIsNowTabShow=" + this.f446628h + " plan=" + c16);
            }
            if (this.f446628h != 0) {
                z16 = true;
            }
            this.f446627f = z16;
            if (z16) {
                h();
                if (this.f446625d.isCallTabShow) {
                    g();
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(LogTag.TAG_STORY_FOUR_TAB, 2, "isNowTabShow fullVal is null");
        }
    }

    public void h() {
        ILebaHelperService iLebaHelperService = (ILebaHelperService) this.f446625d.getRuntimeService(ILebaHelperService.class, "");
        if (iLebaHelperService != null) {
            iLebaHelperService.setFlagUpdateOnPause();
        } else {
            QLog.d("NowLiveManager", 1, "setFlagUpdateOnPause lebaHelperService == null");
        }
    }

    public void i(MessageForStructing messageForStructing) {
        if (this.G.containsKey(messageForStructing.frienduin)) {
            long longValue = this.G.get(messageForStructing.frienduin).longValue();
            long j3 = messageForStructing.time;
            if (j3 > longValue) {
                this.G.put(messageForStructing.frienduin, Long.valueOf(j3));
                this.f446626e.edit().putLong("time" + messageForStructing.frienduin, messageForStructing.time).commit();
            }
        } else {
            this.G.put(messageForStructing.frienduin, Long.valueOf(messageForStructing.time));
            this.f446626e.edit().putLong("time" + messageForStructing.frienduin, messageForStructing.time).commit();
        }
        this.f446626e.edit().putLong("uid" + messageForStructing.frienduin, messageForStructing.msgUid).commit();
    }

    public void j(Integer[] numArr) {
        k(numArr, true);
    }

    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v7 */
    public void k(Integer[] numArr, boolean z16) {
        ?? r56;
        Integer num;
        ?? r57;
        String e16 = e();
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.TAG_STORY_FOUR_TAB, 2, "writeNowTabStateVal fullVal=" + e16 + " vals:" + Arrays.toString(numArr) + "     mNowTabShowState=" + this.f446628h);
        }
        if (e16 != null && e16.length() <= 5 && numArr != null && numArr.length == 5) {
            if (e16.length() < 5) {
                e16 = e16 + "00100".substring(e16.length());
            }
            StringBuilder sb5 = new StringBuilder(e16);
            for (int i3 = 0; i3 < numArr.length; i3++) {
                Integer num2 = numArr[i3];
                if (num2 != null) {
                    if (num2.intValue() >= 0 && num2.intValue() <= 9) {
                        sb5.setCharAt(i3, (char) (num2.intValue() + 48));
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e(LogTag.TAG_STORY_FOUR_TAB, 2, "writeNowTabStateVal wrong index,," + num2);
                            return;
                        }
                        return;
                    }
                }
            }
            char charAt = sb5.charAt(2);
            if ('1' == sb5.charAt(0)) {
                if (sb5.charAt(3) != '0' && charAt != '0' && charAt != '1') {
                    r57 = 1;
                } else {
                    r57 = 0;
                }
                this.f446628h = r57;
                this.f446627f = r57;
                h();
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.TAG_STORY_FOUR_TAB, 2, "userChange mNowTabShowState=" + this.f446628h + " result:" + ((Object) sb5) + "  plan=" + charAt);
                }
            } else {
                if (sb5.charAt(1) != '0' && charAt != '0' && charAt != '1') {
                    r56 = 1;
                } else {
                    r56 = 0;
                }
                this.f446628h = r56;
                this.f446627f = r56;
                if (r56 != 0) {
                    h();
                }
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.TAG_STORY_FOUR_TAB, 2, "userNoChange mNowTabShowState=" + this.f446628h + " result:" + ((Object) sb5) + "  plan=" + charAt);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_STORY_FOUR_TAB, 2, "uin:" + this.f446625d.getCurrentAccountUin() + ",writeNowTabStateVal vals=" + Arrays.toString(numArr) + ",mIsNowTabShow=" + this.f446628h + ",isNowTabShow=" + this.f446627f);
            }
            String sb6 = sb5.toString();
            this.E = sb6;
            this.f446625d.getApp().getSharedPreferences("now_tab_sp", 0).edit().putString("now_show_key" + this.f446625d.getCurrentAccountUin(), sb6).apply();
            String readValue = SettingCloneUtil.readValue(this.f446625d.getApplication(), this.f446625d.getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_CALLTAB_SHOW_KEY, AppConstants.CallTabType.CALLTAB_DEFAULTVAL);
            if (z16 && (num = numArr[0]) != null && 1 == num.intValue() && readValue.charAt(0) == '0') {
                Integer[] numArr2 = new Integer[7];
                numArr2[0] = 1;
                this.f446625d.writeCallTabStateVal(numArr2, false);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(LogTag.TAG_STORY_FOUR_TAB, 2, "writeNowTabStateVal valid val," + e16 + "," + numArr);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        deleteObservers();
        this.f446625d = null;
    }

    private void g() {
    }
}
