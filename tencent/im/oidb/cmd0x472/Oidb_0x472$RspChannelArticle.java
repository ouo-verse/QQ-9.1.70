package tencent.im.oidb.cmd0x472;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x472$RspChannelArticle extends MessageMicro<Oidb_0x472$RspChannelArticle> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint64_channel_id", "rpt_article_list"}, new Object[]{0L, null}, Oidb_0x472$RspChannelArticle.class);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<Oidb_0x472$ArticleSummary> rpt_article_list = PBField.initRepeatMessage(Oidb_0x472$ArticleSummary.class);
}
