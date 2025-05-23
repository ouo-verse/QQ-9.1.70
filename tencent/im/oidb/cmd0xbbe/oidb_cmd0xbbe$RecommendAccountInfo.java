package tencent.im.oidb.cmd0xbbe;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbbe$RecommendAccountInfo extends MessageMicro<oidb_cmd0xbbe$RecommendAccountInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_head_img_url;
    public final PBBytesField bytes_nick_name;
    public final PBBytesField bytes_recommend_reason;
    public final PBUInt32Field uint32_is_followed;
    public final PBUInt32Field uint32_is_star;
    public final PBUInt32Field uint32_is_vip;
    public final PBUInt32Field uint32_strategy_id;
    public final PBUInt64Field uint64_algorithm_id;
    public final PBUInt64Field uint64_issue_time;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56, 64, 72, 80, 88}, new String[]{"uint64_uin", "uint32_account_type", "bytes_recommend_reason", "bytes_nick_name", "bytes_head_img_url", "uint32_is_vip", "uint32_is_star", "uint32_is_followed", "uint64_algorithm_id", "uint32_strategy_id", "uint64_issue_time"}, new Object[]{0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0L, 0, 0L}, oidb_cmd0xbbe$RecommendAccountInfo.class);
    }

    public oidb_cmd0xbbe$RecommendAccountInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_recommend_reason = PBField.initBytes(byteStringMicro);
        this.bytes_nick_name = PBField.initBytes(byteStringMicro);
        this.bytes_head_img_url = PBField.initBytes(byteStringMicro);
        this.uint32_is_vip = PBField.initUInt32(0);
        this.uint32_is_star = PBField.initUInt32(0);
        this.uint32_is_followed = PBField.initUInt32(0);
        this.uint64_algorithm_id = PBField.initUInt64(0L);
        this.uint32_strategy_id = PBField.initUInt32(0);
        this.uint64_issue_time = PBField.initUInt64(0L);
    }
}
