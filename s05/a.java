package s05;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.utils.ac;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a extends RemoteCommand {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f433072a;

    public a(QQAppInterface qQAppInterface) {
        super("common.get_qq_app_interface_data");
        this.f433072a = qQAppInterface;
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand
    public Bundle invoke(Bundle bundle, RemoteCommand.OnInvokeFinishLinstener onInvokeFinishLinstener) {
        int i3 = bundle.getInt("param_data_type", 0);
        Bundle bundle2 = new Bundle();
        if (i3 != 1) {
            if (i3 == 2) {
                bundle2.putString(RemoteCommand.RESULT_KEY, ac.g(this.f433072a, bundle.getString("param_uin"), bundle.getBoolean("param_fetch_if_not_exist", false)));
            }
        } else {
            bundle2.putString(RemoteCommand.RESULT_KEY, ac.f(this.f433072a, bundle.getString("param_uin")));
        }
        return bundle2;
    }
}
