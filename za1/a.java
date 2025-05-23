package za1;

import android.content.Intent;
import com.tencent.mobileqq.config.k;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements k {

    /* renamed from: a, reason: collision with root package name */
    private final ConfigServlet f452186a = new ConfigServlet();

    @Override // com.tencent.mobileqq.config.k
    public boolean a(AppRuntime appRuntime, int[] iArr) {
        return this.f452186a.V0(appRuntime, iArr);
    }

    @Override // com.tencent.mobileqq.config.k
    public void b(int[] iArr, FromServiceMsg fromServiceMsg) {
        this.f452186a.j1(iArr, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.config.k
    public int[] c() {
        return ConfigServlet.f202909d;
    }

    @Override // com.tencent.mobileqq.config.k
    public void d(AppRuntime appRuntime, ConfigurationService$RespGetConfig configurationService$RespGetConfig, Intent intent, int[] iArr, boolean z16) {
        this.f452186a.g1(appRuntime, configurationService$RespGetConfig, intent, iArr, z16);
    }

    @Override // com.tencent.mobileqq.config.k
    public void e(AppRuntime appRuntime, List<Integer> list) {
        this.f452186a.i1(appRuntime, list);
    }

    @Override // com.tencent.mobileqq.config.k
    public void f(AppRuntime appRuntime, Intent intent, ConfigurationService$ReqGetConfig configurationService$ReqGetConfig, int[] iArr, List<ConfigurationService$ConfigSeq> list, List<Integer> list2, String str) {
        this.f452186a.f1(appRuntime, intent, configurationService$ReqGetConfig, iArr, list, list2, str);
    }

    @Override // com.tencent.mobileqq.config.k
    public void g(AppRuntime appRuntime, ConfigurationService$RespGetConfig configurationService$RespGetConfig, List<Integer> list, Intent intent, int[] iArr, boolean z16) {
        this.f452186a.h1(appRuntime, configurationService$RespGetConfig, intent, list, iArr, z16);
    }

    @Override // com.tencent.mobileqq.config.k
    public void h(ConfigurationService$RespGetConfig configurationService$RespGetConfig) {
        this.f452186a.e1(configurationService$RespGetConfig);
    }
}
