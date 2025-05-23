package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d8$RspBody extends MessageMicro<oidb_0x6d8$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"file_info_rsp", "file_list_info_rsp", "group_file_cnt_rsp", "group_space_rsp", "file_preview_rsp"}, new Object[]{null, null, null, null, null}, oidb_0x6d8$RspBody.class);
    public oidb_0x6d8$GetFileInfoRspBody file_info_rsp = new oidb_0x6d8$GetFileInfoRspBody();
    public oidb_0x6d8$GetFileListRspBody file_list_info_rsp = new oidb_0x6d8$GetFileListRspBody();
    public oidb_0x6d8$GetFileCountRspBody group_file_cnt_rsp = new oidb_0x6d8$GetFileCountRspBody();
    public oidb_0x6d8$GetSpaceRspBody group_space_rsp = new oidb_0x6d8$GetSpaceRspBody();
    public oidb_0x6d8$GetFilePreviewRspBody file_preview_rsp = new oidb_0x6d8$GetFilePreviewRspBody();
}
