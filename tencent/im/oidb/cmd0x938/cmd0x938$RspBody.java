package tencent.im.oidb.cmd0x938;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x938$RspBody extends MessageMicro<cmd0x938$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"msg_comm_param", "msg_client_config", "msg_datacard_config", "msg_operation_config", "msg_scorelist_config", "msg_floatbutton_config"}, new Object[]{null, null, null, null, null, null}, cmd0x938$RspBody.class);
    public cmd0x938$CommParamRsp msg_comm_param = new MessageMicro<cmd0x938$CommParamRsp>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$CommParamRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x938$CommParamRsp.class);
    };
    public cmd0x938$ClientConfig msg_client_config = new MessageMicro<cmd0x938$ClientConfig>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$ClientConfig
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_card_url_g;
        public final PBBytesField bytes_card_url_h;
        public final PBBytesField bytes_list_jump_url;
        public final PBUInt32Field uint32_show_list = PBField.initUInt32(0);
        public final PBUInt32Field uint32_show_card = PBField.initUInt32(0);
        public final PBUInt64Field uint64_next_time = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"uint32_show_list", "uint32_show_card", "uint64_next_time", "bytes_card_url_h", "bytes_card_url_g", "bytes_list_jump_url"}, new Object[]{0, 0, 0L, byteStringMicro, byteStringMicro, byteStringMicro}, cmd0x938$ClientConfig.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_card_url_h = PBField.initBytes(byteStringMicro);
            this.bytes_card_url_g = PBField.initBytes(byteStringMicro);
            this.bytes_list_jump_url = PBField.initBytes(byteStringMicro);
        }
    };
    public cmd0x938$DataCardConfig msg_datacard_config = new MessageMicro<cmd0x938$DataCardConfig>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$DataCardConfig
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_card_wording;
        public final PBBytesField bytes_tail_wording;
        public final PBUInt32Field uint32_card_wording_color;
        public final PBUInt32Field uint32_entry_ability;
        public final PBUInt32Field uint32_tail_wording_color;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"bytes_card_wording", "bytes_tail_wording", "uint32_entry_ability", "uint32_card_wording_color", "uint32_tail_wording_color"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0}, cmd0x938$DataCardConfig.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_card_wording = PBField.initBytes(byteStringMicro);
            this.bytes_tail_wording = PBField.initBytes(byteStringMicro);
            this.uint32_entry_ability = PBField.initUInt32(0);
            this.uint32_card_wording_color = PBField.initUInt32(0);
            this.uint32_tail_wording_color = PBField.initUInt32(0);
        }
    };
    public cmd0x938$OperationConfig msg_operation_config = new MessageMicro<cmd0x938$OperationConfig>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$OperationConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_button_wording"}, new Object[]{ByteStringMicro.EMPTY}, cmd0x938$OperationConfig.class);
        public final PBBytesField bytes_button_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public cmd0x938$ScoreListConfig msg_scorelist_config = new MessageMicro<cmd0x938$ScoreListConfig>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$ScoreListConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_multi_mode"}, new Object[]{0}, cmd0x938$ScoreListConfig.class);
        public final PBUInt32Field uint32_multi_mode = PBField.initUInt32(0);
    };
    public cmd0x938$FloatButtonConfig msg_floatbutton_config = new MessageMicro<cmd0x938$FloatButtonConfig>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$FloatButtonConfig
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_button_image_url;
        public final PBBytesField bytes_button_wording;
        public final PBUInt32Field uint32_button_back_color;
        public final PBUInt32Field uint32_button_word_color;
        public final PBUInt32Field uint32_like_count;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"bytes_button_wording", "bytes_button_image_url", "uint32_button_word_color", "uint32_button_back_color", "uint32_like_count"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0}, cmd0x938$FloatButtonConfig.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_button_wording = PBField.initBytes(byteStringMicro);
            this.bytes_button_image_url = PBField.initBytes(byteStringMicro);
            this.uint32_button_word_color = PBField.initUInt32(0);
            this.uint32_button_back_color = PBField.initUInt32(0);
            this.uint32_like_count = PBField.initUInt32(0);
        }
    };
}
