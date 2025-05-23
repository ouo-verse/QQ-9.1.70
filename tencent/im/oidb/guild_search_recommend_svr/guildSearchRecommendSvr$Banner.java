package tencent.im.oidb.guild_search_recommend_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class guildSearchRecommendSvr$Banner extends MessageMicro<guildSearchRecommendSvr$Banner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"pic_url", "jump_url"}, new Object[]{"", ""}, guildSearchRecommendSvr$Banner.class);
    public final PBStringField pic_url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
}
