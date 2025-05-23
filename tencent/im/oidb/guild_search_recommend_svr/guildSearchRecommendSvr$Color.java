package tencent.im.oidb.guild_search_recommend_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class guildSearchRecommendSvr$Color extends MessageMicro<guildSearchRecommendSvr$Color> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_r", "uint32_g", "uint32_b"}, new Object[]{0, 0, 0}, guildSearchRecommendSvr$Color.class);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
}
