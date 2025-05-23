package rk1;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper;
import com.tencent.mobileqq.guild.feed.publish.event.GuildSaveDraftTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ab extends b {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(GuildSaveDraftTaskOperationEvent guildSaveDraftTaskOperationEvent) {
        guildSaveDraftTaskOperationEvent.saveInFile();
        bl.c().b(guildSaveDraftTaskOperationEvent, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "saveDraft";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        in1.e l3 = l();
        if (l3 == null || l3.getInitBean().isEditDraft()) {
            return false;
        }
        final GuildSaveDraftTaskOperationEvent guildSaveDraftTaskOperationEvent = new GuildSaveDraftTaskOperationEvent(String.valueOf(System.currentTimeMillis()));
        guildSaveDraftTaskOperationEvent.setMainTaskId(GuildUploadHelper.i().h());
        guildSaveDraftTaskOperationEvent.setFeedJson(j());
        if (guildSaveDraftTaskOperationEvent.isOverIpcThresholdLength()) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild_Feed_BaseGuildJsBridgeMethod", 1, "[onInvoke] save draft event via file, event.taskId " + guildSaveDraftTaskOperationEvent.getMainTaskId());
            }
            ThreadManagerV2.excute(new Runnable() { // from class: rk1.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ab.q(GuildSaveDraftTaskOperationEvent.this);
                }
            }, 64, null, false);
        } else {
            bl.c().b(guildSaveDraftTaskOperationEvent, true);
        }
        return true;
    }
}
