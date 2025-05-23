package q81;

import android.content.Intent;
import com.tencent.aiosharemusic.b;
import com.tencent.mobileqq.webview.WebViewAioShareMusicHelper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends WebViewPlugin implements b.a {

    /* renamed from: d, reason: collision with root package name */
    private WebViewAioShareMusicHelper f428709d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f428710e;

    @Override // com.tencent.aiosharemusic.b.a
    public void b(String str, JSONObject jSONObject) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.f() == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AioShareMusic.AioShareMusicPlugin", 2, "onEvent\uff08\uff09 actionType =" + str + " data = " + jSONObject.toString());
        }
        if (this.f428709d == null) {
            this.f428709d = new WebViewAioShareMusicHelper((WebViewFragment) this.mRuntime.f());
        }
        if ("checkAioShareMusic".equals(str)) {
            this.f428709d.e(jSONObject);
            return;
        }
        if ("startListenAioShareMusic".equals(str)) {
            this.f428709d.f(jSONObject);
            return;
        }
        if ("updateSongIdToAioShareMusic".equals(str)) {
            try {
                String string = jSONObject.getString("current_song_id");
                this.f428709d.f313783b = string;
                if (QLog.isColorLevel()) {
                    QLog.d("AioShareMusicAioShareMusic.AioShareMusicPlugin", 2, "updateSongId() newSongId = " + string);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "aioShareMusic";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8589934622L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        Object obj;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.f() == null || this.mRuntime.a() == null) {
            return true;
        }
        if (this.f428709d == null) {
            this.f428709d = new WebViewAioShareMusicHelper((WebViewFragment) this.mRuntime.f());
        }
        if (QLog.isColorLevel()) {
            QLog.d("AioShareMusicAioShareMusic.AioShareMusicPlugin", 2, "handleEvent() type = " + j3);
        }
        if (j3 == 8589934594L) {
            if (!this.f428710e) {
                this.f428710e = true;
                this.f428709d.c(this.mRuntime.a().getIntent());
                return true;
            }
        } else if (j3 == 8589934622L && (obj = map.get("intent")) != null && (obj instanceof Intent)) {
            this.f428709d.l((Intent) obj);
            return true;
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        b.c().d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        WebViewAioShareMusicHelper webViewAioShareMusicHelper = this.f428709d;
        if (webViewAioShareMusicHelper != null) {
            webViewAioShareMusicHelper.h();
            this.f428709d = null;
        }
        b.c().unregister();
    }
}
