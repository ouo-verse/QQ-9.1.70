package q61;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, Set<Long>> f428450a = new ConcurrentHashMap<>();

    public static synchronized void a(String str, HashSet<Long> hashSet) {
        synchronized (a.class) {
            if (!TextUtils.isEmpty(str) && hashSet != null) {
                if (f428450a == null) {
                    f428450a = new ConcurrentHashMap<>();
                }
                if (f428450a.containsKey(str) && f428450a.get(str) != null) {
                    f428450a.get(str).addAll(hashSet);
                    QLog.i("GuildOneClickJumpMsgFilter", 1, "setPreRemoveMsgList, channelId = " + str + ", sPreRemoveMsgSet = " + f428450a);
                }
                f428450a.put(str, hashSet);
                QLog.i("GuildOneClickJumpMsgFilter", 1, "setPreRemoveMsgList, channelId = " + str + ", sPreRemoveMsgSet = " + f428450a);
            }
        }
    }
}
