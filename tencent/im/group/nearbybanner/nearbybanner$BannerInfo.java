package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearbybanner$BannerInfo extends MessageMicro<nearbybanner$BannerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"uint32_jump_type", "bytes_img_url", "msg_web_banner", "msg_recomm_banner", "msg_set_banner", "msg_search_banner", "msg_create_banner"}, new Object[]{0, ByteStringMicro.EMPTY, null, null, null, null, null}, nearbybanner$BannerInfo.class);
    public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    public final PBBytesField bytes_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public nearbybanner$WebBanner msg_web_banner = new MessageMicro<nearbybanner$WebBanner>() { // from class: tencent.im.group.nearbybanner.nearbybanner$WebBanner
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_jump_url"}, new Object[]{ByteStringMicro.EMPTY}, nearbybanner$WebBanner.class);
        public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public nearbybanner$RecommGroupBanner msg_recomm_banner = new MessageMicro<nearbybanner$RecommGroupBanner>() { // from class: tencent.im.group.nearbybanner.nearbybanner$RecommGroupBanner
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_group_code"}, new Object[]{0L}, nearbybanner$RecommGroupBanner.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    };
    public nearbybanner$SetGroupBanner msg_set_banner = new MessageMicro<nearbybanner$SetGroupBanner>() { // from class: tencent.im.group.nearbybanner.nearbybanner$SetGroupBanner
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_group_code"}, new Object[]{0L}, nearbybanner$SetGroupBanner.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    };
    public nearbybanner$SearchBanner msg_search_banner = new MessageMicro<nearbybanner$SearchBanner>() { // from class: tencent.im.group.nearbybanner.nearbybanner$SearchBanner
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_search_keyword"}, new Object[]{ByteStringMicro.EMPTY}, nearbybanner$SearchBanner.class);
        public final PBBytesField bytes_search_keyword = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public nearbybanner$CreateGroupBanner msg_create_banner = new MessageMicro<nearbybanner$CreateGroupBanner>() { // from class: tencent.im.group.nearbybanner.nearbybanner$CreateGroupBanner
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_group_type"}, new Object[]{0}, nearbybanner$CreateGroupBanner.class);
        public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    };
}
