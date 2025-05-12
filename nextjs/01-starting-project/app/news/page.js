import Link from "next/link";

export default function NewsPage() {
  return (
    <>
      <h1>News Page</h1>
      <ul>
        <li>
          <Link href="/news/test1">Test 1</Link>
        </li>
        <li>
          <Link href="/news/test2">Test 2</Link>
        </li>
        <li>
          <Link href="/news/test3">Test 3</Link>
        </li>
      </ul>
    </>
  );
}
