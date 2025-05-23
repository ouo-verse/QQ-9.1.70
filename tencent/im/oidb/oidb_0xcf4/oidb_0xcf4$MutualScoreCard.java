package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$MutualScoreCard extends MessageMicro<oidb_0xcf4$MutualScoreCard> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_button_describe;
    public final PBBytesField bytes_button_url;
    public final PBBytesField bytes_level_describe;
    public final PBBytesField bytes_title;
    public final PBBytesField bytes_type_describe;
    public final PBUInt32Field uint32_score;
    public final PBEnumField eMutualMarkNewType = PBField.initEnum(1);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_days = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 82, 88, 98, 106, 114, 122}, new String[]{"eMutualMarkNewType", "uint32_level", "uint32_days", "bytes_title", "uint32_score", "bytes_type_describe", "bytes_level_describe", "bytes_button_describe", "bytes_button_url"}, new Object[]{1, 0, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0xcf4$MutualScoreCard.class);
    }

    public oidb_0xcf4$MutualScoreCard() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.uint32_score = PBField.initUInt32(0);
        this.bytes_type_describe = PBField.initBytes(byteStringMicro);
        this.bytes_level_describe = PBField.initBytes(byteStringMicro);
        this.bytes_button_describe = PBField.initBytes(byteStringMicro);
        this.bytes_button_url = PBField.initBytes(byteStringMicro);
    }
}
