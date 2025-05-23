package tencent.im.oidb.search;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicSearch$ExtensionRequestInfo extends MessageMicro<DynamicSearch$ExtensionRequestInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField action;
    public final PBBytesField city;
    public final PBUInt32Field key_word_src;
    public final PBFloatField latitude;
    public final PBFloatField longitude;
    public final PBInt32Field radius;
    public final PBBytesField region;
    public final PBRepeatField<Long> rpt_pubacc_local_result;

    static {
        String[] strArr = {"action", "latitude", "longitude", "radius", "city", TtmlNode.TAG_REGION, "key_word_src", "rpt_pubacc_local_result"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21, 29, 32, 42, 50, 56, 64}, strArr, new Object[]{byteStringMicro, valueOf, valueOf, 0, byteStringMicro, byteStringMicro, 0, 0L}, DynamicSearch$ExtensionRequestInfo.class);
    }

    public DynamicSearch$ExtensionRequestInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.action = PBField.initBytes(byteStringMicro);
        this.latitude = PBField.initFloat(0.0f);
        this.longitude = PBField.initFloat(0.0f);
        this.radius = PBField.initInt32(0);
        this.city = PBField.initBytes(byteStringMicro);
        this.region = PBField.initBytes(byteStringMicro);
        this.key_word_src = PBField.initUInt32(0);
        this.rpt_pubacc_local_result = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    }
}
