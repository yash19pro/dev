import streamlit as st
import difflib

st.set_page_config(layout="wide")
st.title("🔍 Side-by-Side Text Comparison")

col1, col2 = st.columns(2)

with col1:
    st.subheader("Text File 1")
    file1 = st.file_uploader("Upload first file", type=["txt"], key="file1")
    text1 = file1.read().decode("utf-8") if file1 else st.text_area("Or paste text for File 1", height=300, key="text1")

with col2:
    st.subheader("Text File 2")
    file2 = st.file_uploader("Upload second file", type=["txt"], key="file2")
    text2 = file2.read().decode("utf-8") if file2 else st.text_area("Or paste text for File 2", height=300, key="text2")

if text1 and text2:
    st.subheader("📊 Side-by-Side Diff")

    differ = difflib.HtmlDiff(tabsize=4, wrapcolumn=80)
    diff_html = differ.make_table(
        text1.splitlines(), text2.splitlines(),
        fromdesc="File 1", todesc="File 2",
        context=True, numlines=3
    )

    st.markdown(
        f"""
        <style>
        table.diff {{ width: 100%; font-family: monospace; font-size: 14px; }}
        .diff_header {{ background-color: #f8f9fa; font-weight: bold; }}
        td.diff_header {{ background-color: #f1f1f1; }}
        .diff_add {{ background-color: #d4edda; }}
        .diff_chg {{ background-color: #fff3cd; }}
        .diff_sub {{ background-color: #f8d7da; }}
        </style>
        {diff_html}
        """,
        unsafe_allow_html=True
    )
else:
    st.info("Upload or paste both files/texts to see the side-by-side difference.")
