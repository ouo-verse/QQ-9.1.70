package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.xweb.updater.IXWebBroadcastListener;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCList$GetFeedReply extends MessageMicro<ShadowAIGCList$GetFeedReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"feed_infos", IXWebBroadcastListener.STAGE_FINISHED}, new Object[]{null, Boolean.FALSE}, ShadowAIGCList$GetFeedReply.class);
    public final PBRepeatMessageField<ShadowAIGCList$FeedInfo> feed_infos = PBField.initRepeatMessage(ShadowAIGCList$FeedInfo.class);
    public final PBBoolField finished = PBField.initBool(false);
}
