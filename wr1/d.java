package wr1;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static volatile d f446119b;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, HashSet<Long>> f446120a = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
    }

    public d() {
        i(null);
    }

    private HashSet<Long> d(JSONObject jSONObject, String str) {
        HashSet<Long> hashSet = new HashSet<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                if (jSONArray.get(i3) instanceof Integer) {
                    hashSet.add(Long.valueOf(((Integer) jSONArray.get(i3)).longValue()));
                } else if (jSONArray.get(i3) instanceof Long) {
                    hashSet.add((Long) jSONArray.get(i3));
                } else {
                    QLog.w("Guild.MF.Rt.GuildChannelCollapseHelper", 1, "loadCollapseMapFromSP parse guildGroup, guildId:" + str + " data:" + jSONArray.get(i3));
                }
            }
        } catch (JSONException e16) {
            QLog.e("Guild.MF.Rt.GuildChannelCollapseHelper", 1, "loadCollapseMapFromSP parse guildGroup err, guildId:" + str + " err:" + e16);
        }
        return hashSet;
    }

    public static d e() {
        if (f446119b == null) {
            synchronized (d.class) {
                if (f446119b == null) {
                    f446119b = new d();
                }
            }
        }
        return f446119b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        bw.L().encodeString("GUILD_CHANNEL_GROUP_COLLAPSE_STATUS_MAP", new JSONObject(this.f446120a).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void f(@Nullable final a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        String decodeString = bw.L().decodeString("GUILD_CHANNEL_GROUP_COLLAPSE_STATUS_MAP", null);
        if (TextUtils.isEmpty(decodeString)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(decodeString);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!((IGPSService) ch.R0(IGPSService.class)).isGuest(str)) {
                    HashSet<Long> d16 = d(jSONObject, str);
                    HashSet<Long> hashSet = this.f446120a.get(str);
                    if (hashSet != null) {
                        hashSet.addAll(d16);
                    } else {
                        this.f446120a.put(str, d16);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("Guild.MF.Rt.GuildChannelCollapseHelper", 2, String.format("loadCollapseMapFromSP, time:%d(ms) data:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), decodeString));
            }
            if (aVar != null) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(aVar) { // from class: wr1.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        throw null;
                    }
                });
            }
        } catch (JSONException e16) {
            QLog.e("Guild.MF.Rt.GuildChannelCollapseHelper", 1, String.format("loadCollapseMapFromSP collapseData:%s err:%s", decodeString, e16));
        }
    }

    private void j() {
        ThreadManagerV2.excute(new Runnable() { // from class: wr1.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.g();
            }
        }, 64, null, true);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str) && this.f446120a.containsKey(str)) {
            this.f446120a.remove(str);
            j();
        }
    }

    public void i(@Nullable final a aVar) {
        if (this.f446120a.isEmpty()) {
            ThreadManagerV2.excute(new Runnable(aVar) { // from class: wr1.a
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.f(null);
                }
            }, 64, null, true);
        }
    }
}
