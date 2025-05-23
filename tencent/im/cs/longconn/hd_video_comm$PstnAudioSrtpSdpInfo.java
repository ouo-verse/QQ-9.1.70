package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class hd_video_comm$PstnAudioSrtpSdpInfo extends MessageMicro<hd_video_comm$PstnAudioSrtpSdpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56}, new String[]{"enum_crypto_method", "uint32_crypto_tag", "bytes_raw_key", "uint32_life_time", "uint32_mki_value", "uint32_mki_len", "uint32_key_derivation_rate"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0, 0, 0, 0}, hd_video_comm$PstnAudioSrtpSdpInfo.class);
    public final PBEnumField enum_crypto_method = PBField.initEnum(0);
    public final PBUInt32Field uint32_crypto_tag = PBField.initUInt32(0);
    public final PBBytesField bytes_raw_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_life_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mki_value = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mki_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_key_derivation_rate = PBField.initUInt32(0);
}
