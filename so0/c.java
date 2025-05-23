package so0;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan;
import com.tencent.guild.aio.util.aa;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import so0.c;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Editable f434023d;

        a(Editable editable) {
            this.f434023d = editable;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return this.f434023d.getSpanStart(obj) - this.f434023d.getSpanStart(obj2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Editable f434024d;

        b(Editable editable) {
            this.f434024d = editable;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return this.f434024d.getSpanStart(obj) - this.f434024d.getSpanStart(obj2);
        }
    }

    /* compiled from: P */
    /* renamed from: so0.c$c, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C11241c implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Editable f434025d;

        C11241c(Editable editable) {
            this.f434025d = editable;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return this.f434025d.getSpanStart(obj) - this.f434025d.getSpanStart(obj2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface d {
        void onResult(List<String> list);
    }

    public static String c(IGProUserInfo iGProUserInfo) {
        if (iGProUserInfo == null) {
            return "";
        }
        if (!TextUtils.isEmpty(iGProUserInfo.getDisplayName())) {
            return iGProUserInfo.getDisplayName();
        }
        return "\u9891\u9053\u7528\u6237";
    }

    public static ArrayList<String> d(String str) {
        QLog.d("GuildAtUtil", 2, "getRecentRobotIdList key=" + str);
        String atRobotRecentRecord = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getAtRobotRecentRecord(str);
        if (!TextUtils.isEmpty(atRobotRecentRecord)) {
            return new ArrayList<>(Arrays.asList(atRobotRecentRecord.split("\\|")));
        }
        return new ArrayList<>();
    }

    public static void e(String str, String str2, final d dVar) {
        QLog.d("GuildAtUtil", 1, "getRecentUserIdList channelId=" + str2);
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(new Contact(4, str2, str), 0L, 30, true, new IMsgOperateCallback() { // from class: so0.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str3, ArrayList arrayList) {
                c.g(c.d.this, i3, str3, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(final d dVar, int i3, String str, ArrayList arrayList) {
        int size;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getRecentUserIdList result=");
        sb5.append(i3);
        sb5.append(" errMsg=");
        sb5.append(str);
        sb5.append("listSize=");
        if (arrayList == null) {
            size = 0;
        } else {
            size = arrayList.size();
        }
        sb5.append(size);
        QLog.d("GuildAtUtil", 1, sb5.toString());
        final ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                String senderUid = ((MsgRecord) arrayList.get(size2)).getSenderUid();
                if (!arrayList2.contains(senderUid)) {
                    arrayList2.add(senderUid);
                }
            }
        }
        aa.b(new Runnable() { // from class: so0.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d.this.onResult(arrayList2);
            }
        });
    }

    public static int h(EditText editText) {
        Editable editableText = editText.getEditableText();
        AtTroopMemberSpan[] atTroopMemberSpanArr = (AtTroopMemberSpan[]) editableText.getSpans(0, editText.getSelectionStart(), AtTroopMemberSpan.class);
        if (atTroopMemberSpanArr != null && atTroopMemberSpanArr.length != 0) {
            Arrays.sort(atTroopMemberSpanArr, new a(editableText));
            return editableText.getSpanStart(atTroopMemberSpanArr[atTroopMemberSpanArr.length - 1]);
        }
        return -1;
    }

    public static AtTroopMemberSpan i(EditText editText) {
        Editable editableText = editText.getEditableText();
        AtTroopMemberSpan[] atTroopMemberSpanArr = (AtTroopMemberSpan[]) editableText.getSpans(0, editText.getSelectionStart(), AtTroopMemberSpan.class);
        if (atTroopMemberSpanArr != null && atTroopMemberSpanArr.length != 0) {
            Arrays.sort(atTroopMemberSpanArr, new C11241c(editableText));
            return atTroopMemberSpanArr[atTroopMemberSpanArr.length - 1];
        }
        return null;
    }

    public static int j(Editable editable, int i3, int i16) {
        AtTroopMemberSpan[] atTroopMemberSpanArr = (AtTroopMemberSpan[]) editable.getSpans(i3, i16, AtTroopMemberSpan.class);
        if (atTroopMemberSpanArr != null && atTroopMemberSpanArr.length != 0) {
            Arrays.sort(atTroopMemberSpanArr, new b(editable));
            return editable.getSpanEnd(atTroopMemberSpanArr[atTroopMemberSpanArr.length - 1]);
        }
        return -1;
    }

    public static void k(String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            int min = Math.min(list.size(), 3);
            for (int i3 = 0; i3 < min; i3++) {
                if (i3 > 0) {
                    sb5.append("|");
                }
                sb5.append(list.get(i3));
            }
            QLog.d("GuildAtUtil", 2, "setRecentRobotIdList  robotRecent = " + ((Object) sb5));
            ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setAtRobotRecentRecord(str, sb5.toString());
        }
    }
}
