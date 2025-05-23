package tencent.im.oidb.guild_search_recommend_svr;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class guildSearchRecommendSvr$Label extends MessageMicro<guildSearchRecommendSvr$Label> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 58}, new String[]{"bytes_name", "text_color", "edging_color", "label_attr", "label_type", "label_value", "icon"}, new Object[]{ByteStringMicro.EMPTY, null, null, 0, 0, "", ""}, guildSearchRecommendSvr$Label.class);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public guildSearchRecommendSvr$Color text_color = new guildSearchRecommendSvr$Color();
    public guildSearchRecommendSvr$Color edging_color = new guildSearchRecommendSvr$Color();
    public final PBUInt32Field label_attr = PBField.initUInt32(0);
    public final PBUInt32Field label_type = PBField.initUInt32(0);
    public final PBStringField label_value = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
}
