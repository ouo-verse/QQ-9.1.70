package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OlympicTorchSvc$RspGetBusinessTorch extends MessageMicro<OlympicTorchSvc$RspGetBusinessTorch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_rsp_head", "msg_torch_info", "msg_scene_wording"}, new Object[]{null, null, null}, OlympicTorchSvc$RspGetBusinessTorch.class);
    public OlympicTorchSvc$RspHead msg_rsp_head = new OlympicTorchSvc$RspHead();
    public torch_transfer$TorchbearerInfo msg_torch_info = new torch_transfer$TorchbearerInfo();
    public OlympicTorchSvc$SceneWording msg_scene_wording = new MessageMicro<OlympicTorchSvc$SceneWording>() { // from class: tencent.im.oidb.olympic.OlympicTorchSvc$SceneWording
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"str_line1", "str_line2", "str_link_word", "str_link_url"}, new Object[]{"", "", "", ""}, OlympicTorchSvc$SceneWording.class);
        public final PBStringField str_line1 = PBField.initString("");
        public final PBStringField str_line2 = PBField.initString("");
        public final PBStringField str_link_word = PBField.initString("");
        public final PBStringField str_link_url = PBField.initString("");
    };
}
