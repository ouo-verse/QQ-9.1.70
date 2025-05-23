package tencent.im.qqwallet;

import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qqwalletaio_resv$qqwalletaio_elem_resv extends MessageMicro<qqwalletaio_resv$qqwalletaio_elem_resv> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_idiom_alpha;
    public final PBBytesField bytes_outer_skin_id;
    public final PBBytesField bytes_subject_image;
    public final PBInt32Field int32_special_pop_id;
    public final PBRepeatMessageField<qqwalletaio_resv$Payer> rpt_payer;
    public final PBUInt32Field sound_record_duration;
    public final PBBytesField transaction_id;
    public final PBUInt32Field uint32_effects_id;
    public final PBUInt32Field uint32_hb_from;
    public final PBUInt32Field uint32_resource_type;
    public final PBUInt32Field uint32_skin_from;
    public final PBUInt32Field uint32_skin_id;
    public final PBUInt32Field uint32_song_flag;
    public final PBUInt32Field uint32_song_id;
    public final PBUInt32Field uint32_subjectid;

    static {
        String[] strArr = {"bytes_subject_image", CommonCode.MapKey.TRANSACTION_ID, "sound_record_duration", "uint32_resource_type", "uint32_skin_id", "uint32_effects_id", "int32_special_pop_id", "rpt_payer", "uint32_subjectid", "uint32_hb_from", "uint32_song_id", "uint32_song_flag", "bytes_idiom_alpha", "bytes_outer_skin_id", "uint32_skin_from"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 66, 72, 80, 88, 96, 106, 114, 120}, strArr, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0}, qqwalletaio_resv$qqwalletaio_elem_resv.class);
    }

    public qqwalletaio_resv$qqwalletaio_elem_resv() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_subject_image = PBField.initBytes(byteStringMicro);
        this.transaction_id = PBField.initBytes(byteStringMicro);
        this.sound_record_duration = PBField.initUInt32(0);
        this.uint32_resource_type = PBField.initUInt32(0);
        this.uint32_skin_id = PBField.initUInt32(0);
        this.uint32_effects_id = PBField.initUInt32(0);
        this.int32_special_pop_id = PBField.initInt32(0);
        this.rpt_payer = PBField.initRepeatMessage(qqwalletaio_resv$Payer.class);
        this.uint32_subjectid = PBField.initUInt32(0);
        this.uint32_hb_from = PBField.initUInt32(0);
        this.uint32_song_id = PBField.initUInt32(0);
        this.uint32_song_flag = PBField.initUInt32(0);
        this.bytes_idiom_alpha = PBField.initBytes(byteStringMicro);
        this.bytes_outer_skin_id = PBField.initBytes(byteStringMicro);
        this.uint32_skin_from = PBField.initUInt32(0);
    }
}
