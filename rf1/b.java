package rf1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.security.GuildChannelSwitchManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import wh2.aa;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    private Bundle f431380i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<List<IGProAppInfo>> f431381m = new MutableLiveData<>();
    private final MutableLiveData<List<of1.b>> C = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1(int i3, String str, ArrayList arrayList) {
        if (i3 == 0) {
            this.f431381m.postValue(arrayList);
        }
    }

    private void initData() {
        if (this.f431380i == null) {
            QLog.w("Guild.c.create.GuildAppChannelViewModel", 1, "arguments is null!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        CreateSubChannelInfo createSubChannelInfo = (CreateSubChannelInfo) this.f431380i.getParcelable("extra_key_subchannel_info");
        if (!d12.a.c()) {
            arrayList.add(new of1.b(R.string.f157431mw, 1));
        }
        if (GuildChannelSwitchManager.d(createSubChannelInfo.f214821d)) {
            arrayList.add(new of1.b(R.string.f141500gu, 5));
        }
        if (GuildChannelSwitchManager.f(createSubChannelInfo.f214821d)) {
            arrayList.add(new of1.b(R.string.f141110fs, 2));
        }
        if (!GuildDebugUtils.f(createSubChannelInfo.f214821d)) {
            arrayList.add(new of1.b(R.string.f157421mv, 7));
        }
        if (!d12.a.c()) {
            arrayList.add(new of1.b(R.string.f157361mp, 6));
        }
        this.C.setValue(arrayList);
    }

    @NonNull
    public LiveData<List<IGProAppInfo>> M1() {
        return this.f431381m;
    }

    @NonNull
    public LiveData<List<of1.b>> N1() {
        return this.C;
    }

    public void P1(AppRuntime appRuntime, String str) {
        this.f431381m.postValue(null);
        ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).fetchAppInfos(str, new aa() { // from class: rf1.a
            @Override // wh2.aa
            public final void onResult(int i3, String str2, ArrayList arrayList) {
                b.this.O1(i3, str2, arrayList);
            }
        });
    }

    public void init(Bundle bundle) {
        this.f431380i = bundle;
        initData();
    }
}
