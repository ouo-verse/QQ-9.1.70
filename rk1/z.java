package rk1;

import com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRetryTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;

/* compiled from: P */
/* loaded from: classes13.dex */
public class z extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "reUpload";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        String g16 = g(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        GuildRetryTaskOperationEvent guildRetryTaskOperationEvent = new GuildRetryTaskOperationEvent(1, GuildUploadHelper.i().h());
        guildRetryTaskOperationEvent.setTaskId(g16);
        bl.c().b(guildRetryTaskOperationEvent, true);
        return true;
    }
}
