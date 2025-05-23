package wp3;

import android.content.Intent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.agent.util.o;
import com.tencent.open.agent.util.t;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class b {
    public static final String TAG = "OpenListener";

    private void processData(Intent intent) {
        if (intent == null) {
            onError(new a(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
            return;
        }
        int intExtra = intent.getIntExtra("key_error_code", 0);
        if (intExtra != 0) {
            t.e(TAG, "OpenUi, onActivityResult, onError = " + intExtra + "");
            onError(new a(intExtra, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
            return;
        }
        String stringExtra = intent.getStringExtra("key_response");
        if (stringExtra == null) {
            t.b(TAG, "OpenUi, onActivityResult, onComplete");
            onComplete(new JSONObject());
            return;
        }
        try {
            onComplete(o.b(stringExtra));
        } catch (JSONException e16) {
            onError(new a(-4, com.tencent.open.business.base.b.f341054b, stringExtra));
            t.d(TAG, "OpenUi, onActivityResult, json error", e16);
        }
        ReportController.o(null, "dc00898", "", "", "0X800BF27", "0X800BF27", 0, 0, "", "", "", "");
    }

    public boolean onActivityResult(int i3, int i16, Intent intent) {
        t.b(TAG, "onActivityResult req=" + i3 + " res=" + i16);
        if (10001 != i3) {
            return false;
        }
        if (i16 == -1) {
            processData(intent);
        } else {
            onCancel();
        }
        return true;
    }

    public abstract void onCancel();

    public abstract void onComplete(Object obj);

    public abstract void onError(a aVar);

    public abstract void onWarning(int i3);
}
