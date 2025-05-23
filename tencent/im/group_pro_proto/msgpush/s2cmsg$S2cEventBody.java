package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class s2cmsg$S2cEventBody extends MessageMicro<s2cmsg$S2cEventBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 50}, new String[]{"redpoint_event_body", "channel_recommend_daily"}, new Object[]{null, null}, s2cmsg$S2cEventBody.class);
    public s2cmsg$RedpointEventBody redpoint_event_body = new s2cmsg$RedpointEventBody();
    public s2cmsg$ChannelRecommendDaily channel_recommend_daily = new s2cmsg$ChannelRecommendDaily();
}
